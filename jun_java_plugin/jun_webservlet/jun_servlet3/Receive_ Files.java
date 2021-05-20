import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.minstone.docexch.DocExchFactory;
import com.minstone.docexch.DocExchangeApi;
import com.minstone.docexch.model.EDocument;
import com.minstone.docexch.model.EFile;
import com.minstone.docexch.model.ESystemSignReply;

import lotus.domino.AgentBase;
import lotus.domino.AgentContext;
import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.EmbeddedObject;
import lotus.domino.NotesException;
import lotus.domino.RichTextItem;
import lotus.domino.Session;
import lotus.domino.View;

public class JavaAgent extends AgentBase {
	/*
	 * @ CREATE BY CCTC-QZM 20110801
	 */
	Session session = null;
	AgentContext agentContext = null;
	Database db = null;
	Database sysDB = null;
	View sysV = null;
	String workBegin = "";
	Vector vUname = null;
	Vector vPhone = null;
	Vector vEmail = null;

	public void NotesMain() {
		//System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd"); 
		try {
			session = getSession();
			agentContext = session.getAgentContext();
			db = agentContext.getCurrentDatabase();
			getSendInfo();   
			String dbPath = db.getFilePath();   //public/fsyx.nsf
			String dbName = db.getFileName();   //fsyx.nsf
			String path = dbPath.substring(0, dbPath.length() - dbName.length());
			sysDB = session.getDatabase(db.getServer(), path + "xtpzst.nsf");   //xtpzst.nsf�����Ľ�����ϵͳ����
			sysV = sysDB.getView("vXTAnDanWeiDaiMaChaXun");
			System.out.println("=====>> ��ʼ����,����ʡ���ļ��ӿڳ���");
			
			getGatDocs(db, sysDB, sysV);

			System.out.println("=====>> �������");
		} catch (Exception e) {
			e.printStackTrace();
			//������Ϣ���� 
			try{
				if(checkInterval()){
					//sendMail(e.getMessage());
					//createSendSmsForm(e.getMessage());
			        System.out.println("=====>> ������� 1");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		} finally {
			try {
				if (sysV != null) {
					sysV.recycle();
				}
				if (db != null) {
					db.recycle();
				}
				if (sysDB != null) {
					sysDB.recycle();
				}
				if (agentContext != null) {
					agentContext.recycle();
				}
				if (session != null) {
					session.recycle();
				}
				System.gc();
				
			} catch (NotesException e) {
				// TODO �Զ����� catch ��
				e.printStackTrace();
			}
		}
	}


	// ����ʡ���ļ��ӿڳ���
	public void getGatDocs(Database db, Database sysDB, View sysV) {

		try {
			System.out.println("====>> ��ʼ����ʡ���ӿڳ���");
			
			DocExchangeApi docExchApi = DocExchFactory.getInstance();
			// ��ȡ��Ҫ���յĹ���
			System.out.println("====>> docExchApi");
			EDocument[] docs = docExchApi.getNeedReceiveDocument();
			String fName = "";
			ArrayList al = new ArrayList();
			String stral = "";
			System.out.println("====>> ����δ���ĵ���Ϊ��" + docs.length);
			if (docs != null && docs.length > 0) {
				for (int i = 0; i < docs.length; i++) {
					try {
						System.out.println("====>> ���ղ�ת����" + i + "�ݽ����ļ���");

						boolean rcvOK = false;
						// ���ĵ�ȫ��Ψһ��ʶ������һ��128λ��GUID����8d4115a8-b81d-11e0-9c91-f6b0adb9d839  
						String docId = docs[i].getDocumentId();
						// String docMesId = docs[i].getMessageId();
						// ��������ID����ֵ��ʡ��ͳһ���壬����ֵ�ͺ�����ʡ�����Ľ���ϵͳ���塣doc.getMessageId()
						// String docTypeId = docs[i].getDocumentTypeId();
						// ��ȡ����Ҫ����ص��ֶ�ֵ����ͬ�����͵Ĺ��Ĺ���Ҫ�ز�ͬ��
						String exchId = String.valueOf(docs[i].getExchangeId());
				
						String GWBT = docs[i].getFieldString("GWBT");// ���ı���
						String JJCD = docs[i].getFieldString("JJCD");// �����̶�
						String FWJGDM = docs[i].getFieldString("FWJGDM");// ���Ļ��ش���
						String FWJGMC = docs[i].getFieldString("FWJGMC");// ���Ļ�������
						String FWZH = docs[i].getFieldString("FWZH");// �����ֺ�
						if(GWBT.contains("ó�����޹�˾������ҵ��¸�����֪ͨ")) GWBT = "���ڲ鴦���ݿ���ó�����޹�˾������ҵ��¸�����֪ͨ";
						
						String QFRXM = docs[i].getFieldString("QFRXM");// ǩ��������
						String FWSJ = docs[i].getFieldString("FWSJ");// ����ʱ��
						String ZSDW = docs[i].getFieldString("ZSDW");// ����					// String CWRQ = docs[i].getFieldString("CWRQ");//��������
						String SWDWDM = docs[i].getFieldString("SWDWDM");// ���ĵ�λ����
						String SWDW = docs[i].getFieldString("SWDW");// ���ĵ�λ��						
						String FZ = docs[i].getFieldString("FZ");// ��ע
						String CBRXM = docs[i].getFieldString("CBRXM");// �а�������
						String GWLX = docs[i].getFieldString("GWLX");// ��������
						System.out.println("[�ĵ�ID]:"+docId);
						
						System.out.println("[���ı���]��"+GWBT);
						System.out.println("[�����ֺ�]:"+FWZH);
//						System.out.println("[�����̶�]��"+JJCD);
						System.out.println("[���Ļ��ش���]��"+FWJGDM);
						System.out.println("[���ĵ�λ]:"+FWJGMC);						
						System.out.println("[ǩ��������]:"+QFRXM);
						System.out.println("[����ʱ��]:"+FWSJ);
						System.out.println("[���͵�λ]:"+ZSDW);
						System.out.println("[���ĵ�λ����]:"+SWDWDM);
						System.out.println("[���յ�λ]:"+SWDW);
//						System.out.println("[��������]:"+GWLX);
						System.out.println("[��ע]:"+FZ);
						System.out.println("[�а�������]:"+CBRXM);
						
						String SWDWDMArray[] = SWDWDM.toString().split(",");
						stral = GWBT;
						stral += "#" + FWSJ;
						stral += "#" + getStrTime(new Date());						
						stral += "#0";	
						al.add(stral);
						for (int iii = 0; iii < SWDWDMArray.length; iii++) {
							
							if (SWDWDMArray[iii].length() > 0) {//�ж����ĵ�λ�����Ƿ�Ϊ�ա�
								
								if (SWDWDMArray[iii].substring(0, 4).equals("4401")) {//�ж����ĵ�λ�����Ƿ��ǹ����оֵĵ�λ���롣
									
									System.out.println("���ĵ�λ��������SWDWDM��" + SWDWDMArray[iii]);// SWDWDMArray[iii]
									
									// �������ĵ�λ������ѯ���ĵ�λ��������Ա
									Document sysdoc = sysV.getDocumentByKey(SWDWDMArray[iii]);// SWDWDMArray[iii]
									if (sysdoc != null) {
										String strTime = getStrTime(new Date());
										Document doc = db.createDocument();// ������������doc
										// ............................................................��ȡ����start
										
										EFile[] attachs = docs[i].getAttachs();
										System.out.println("EFile���ȣ�" + attachs.length);
										for(int a1 = 0;a1 < attachs.length;a1++)
											System.out.println(attachs[a1].getFileName() + "$$$filesize=" + attachs[a1].getFileSize());
					
										String fuJianID = "";
										
										String path = "/oadata/gzga1/domino/html/UODocTrail/" + doc.getUniversalID();
									 	
										Document fjDoc = null;
										RichTextItem body = null;
										if (attachs.length > 0) {
											// ���������ĵ�
											// System.out
											// .println("GUIDΪ" + docId
											// + "�Ĺ����յ����� "
											// + attachs.length + "��");
											fjDoc = db.createDocument();
											// System.out
											// .println("fjDoc = db.createDocument();");
											fuJianID = fjDoc.getUniversalID();
											// System.out
											// .println("fuJianID = fjDoc.getUniversalID();;");
											fjDoc.replaceItemValue("Form","fHJGaoZhi1");
											fjDoc.replaceItemValue("tKZBenWenDangHao",fuJianID);
											body = fjDoc.createRichTextItem("Body");
											// System.out
											// .println("body = fjDoc.createRichTextItem(");
											
											for (int ii = 0; ii < attachs.length; ii++) {
												EFile ef = attachs[ii];
												String prefix = "";//updated @20160701
												byte[] attachContent = ef.getFileContent();
												// System.out.println("����ef.getFileName()= "
												// + ef.getFileName());
												// System.out.println("����ef.getFileSize()= "
												// + ef.getFileSize());
												
												fName = ef.getFileName();	
												System.out.println("fName:"+fName);
												System.out.println("fName Length:"+fName.length());
												if(fName.contains("ó�����޹�˾÷�������л?�����doc")) fName = "�����ٱ����ݿ���ó�����޹�˾÷������ҽԺ�л߷�����.doc";
//												if(fName.contains("����14")) fName = "����14���ž���ͨ����ʿ����.xls";
//												if(fName.length() > 40) fName = fName.substring(0,40) + "....doc";
												//File f = new File(path + "/" + ef.getFileName());
												
												//updated @20160701--start
												fName = fName.replaceAll("\\?", "\\^");
												if(fName.length()>60){
													prefix = fName.substring(fName.lastIndexOf("."));
													fName = fName.substring(0, 60-prefix.length()-2)+".."+prefix;
												}
												//updated @20160701--end
												
												
												File f = new File(path + "/" + fName);
												
												File fPath = new File(path);
												if (fPath.exists()) {
													// System.err.println("�Ѵ���Ŀ¼ "
													// +
													// path);
												} else {
													fPath.mkdir();
													// System.err.println("�����ļ�Ŀ¼ "
													// +
													// path);
												}
												OutputStream fopts = new FileOutputStream(f);
												fopts.write(attachContent);
												fopts.close();
												//body.embedObject(EmbeddedObject.EMBED_ATTACHMENT,null,path + "/" + ef.getFileName(),"");
												body.embedObject(EmbeddedObject.EMBED_ATTACHMENT,null,path + "/" + fName,"");
											}
											// ���渽���ĵ�
											fjDoc.save(true);
										} else {
											System.out.println("GUIDΪ" + docId	+ "�Ĺ���û�и�����");
										}
										fName = "";
										// ............................................................��ȡ����end
										// ............................................................��ȡ����start
										//System.out.println("��ȡ���� start.");
										String zwID = "";
										EFile textFile = docs[i].getText();
										if (textFile != null) {
											// ���������ĵ�
											// System.out.println("GUIDΪ" +
											// docId
											// + "�Ĺ����յ�����һ��");
											if (fjDoc == null) {
												fjDoc = db.createDocument();
												fuJianID = fjDoc.getUniversalID();
												fjDoc.replaceItemValue("Form","fHJGaoZhi1");
												fjDoc.replaceItemValue("tKZBenWenDangHao",fuJianID);
												body = fjDoc.createRichTextItem("Body");
											}
											byte[] attachContent = textFile	.getFileContent();
											 System.out.println("����textFile.getFileName()= "
											 + textFile.getFileName());
											 System.out.println("����textFile.getFileSize()= "
											 + textFile.getFileSize());
											fName = textFile.getFileName();
											if(fName.length() > 40) fName = fName.substring(0,40) + "....doc";
											File f = new File(path + "/" + fName);
											//File f = new File(path + "/" + textFile.getFileName());
											File fPath = new File(path);
											if (fPath.exists()) {
												// System.err.println("�Ѵ���Ŀ¼ " +
												// path);
											} else {
												fPath.mkdir();
												// System.err.println("�����ļ�Ŀ¼ "
												// +
												// path);
											}
											OutputStream fopts = new FileOutputStream(f);
											fopts.write(attachContent);
											fopts.close();
											//body.embedObject(EmbeddedObject.EMBED_ATTACHMENT,null,path	+ "/" + textFile.getFileName(),"");
											body.embedObject(EmbeddedObject.EMBED_ATTACHMENT,null,path	+ "/" + fName,"");
											// ���������ĵ�
											fjDoc.save(true);
										} else {
											System.out.println("GUIDΪ" + docId	+ "�Ĺ���û������");
										}
										// ............................................................��ȡ���� end
										doc.replaceItemValue("Form","fFaSongXinXiWS");
										doc.replaceItemValue("tJHWenJianLiuShuiHao", docId);
										doc.replaceItemValue("GUID", docId);
										doc.replaceItemValue("tQianShou", "0");
										doc.replaceItemValue("tJHWenJianBiaoTi", GWBT);
										doc.replaceItemValue("tJHWenDangBianHao", FWZH);
										doc.replaceItemValue("tJHJinJiChengDu",getHjcd(JJCD));
										doc.replaceItemValue("FWJGDM", FWJGDM);
										doc.replaceItemValue("tJHFaSongRenDanWei", FWJGMC);
										doc.replaceItemValue("tQianFaRen",QFRXM);
										doc.replaceItemValue("tJHFaSongRiQi",strTime);
										doc.replaceItemValue("SWJGDM",SWDWDMArray[iii]);
										doc.replaceItemValue("tJHFaWenFanWei",ZSDW);
										//doc.replaceItemValue("tJHWenJianLeiXing1_1", GWLX);
										doc.replaceItemValue("tJHWenJianLeiXing1_1", getGwlx(GWLX));  //20140805���getGwlx()����
										doc.replaceItemValue("tBeiZhu", FZ);
										doc.replaceItemValue("tLianXiRen", CBRXM);
//										doc.replaceItemValue("CBRXM", CBRXM);
										//doc.replaceItemValue("tJHFaSongRen",QFRXM);
										// doc.replaceItemValue("tJHMiJi",FWSJ);
										// doc.replaceItemValue("tJHFaSongRen",FWSJ);
										// doc.replaceItemValue("tJSLianXiRen",FWSJ);
										doc.replaceItemValue("tKZFuJianBianHao", fuJianID);// ����id
										doc.replaceItemValue("tFWDingGaoWenDangUNID", zwID);// ����id
										
										// SWDWDMArray[iii]
										// SWDWDMSWJGDM

										String tXTQunZuMing = sysdoc.getItemValueString("tXTQunZuMing");
										System.out.println("���ĵ�λ���ƣ�"	+ tXTQunZuMing);
										Vector v = sysdoc.getItemValue("mXTChengYuan");
										for (int ii = 0; ii < v.size(); ii++) {
											System.out.println((ii + 1)	+ "������Ա: " + v.elementAt(ii));
										}
										doc.replaceItemValue("tJHFaWangDanWei", tXTQunZuMing);
										doc.replaceItemValue("aJSauthors", v);
										doc.replaceItemValue("rJSreaders", v);
										doc.replaceItemValue("Authores_1", db.getManagers());
										doc.replaceItemValue("Readers_1", db.getManagers());
										doc.replaceItemValue("dbManager", db.getManagers());
										doc.save(true);
										

										System.out.println("GUIDΪ" + docId	+ "�Ĺ����Ѿ����������Ĺ��Ľ�����");
										// System.out.println(mXTChengYuan +
										// "��ǩ�հ���");
									} else {
										System.out.println("ϵͳδ�ҵ���λ����Ϊ" + SWDWDMArray[iii]	+ "�ĵ�λ������ϵͳ����Ա��ϵ��");
									}
								} else {
									System.out.println("���ĵ�λ���루SWDWDMArray[iii]" + SWDWDMArray[iii]
										+ "�����ǹ����о�ֱ����λ�ĵ�λ���룬ϵͳ�����Խ��ա�");/**/
								}
							} else {
								System.out.println("���ĵ�λ���루SWDWDMArray[iii]��Ϊ�գ�ϵͳ�����Խ��ա�");
							}
							
							
							//ϵͳǩ��20140721
							
							ESystemSignReply systemSignReply =null;
							systemSignReply = new ESystemSignReply();
							systemSignReply.setMessageId(docId);
							systemSignReply.setReferenceMessageId(docId);
							systemSignReply.setMessageReceiveDate(new Timestamp(System
									.currentTimeMillis()));
							systemSignReply.setMessageReceiver(docExchApi.getLocalSystemId());
							systemSignReply.setReceiverIp(Inet4Address.getLocalHost().getHostAddress());
							
							systemSignReply.setFrom(docExchApi.getLocalSystemId());
							//systemSignReply.setTo("440000000000001");
							systemSignReply.setTo("440000000000001");
							
							
							boolean bSendSysOK=false;
							bSendSysOK = docExchApi.sendDocumentSignReply(systemSignReply);
							if(bSendSysOK){
								System.out.println("����ϵͳǩ�ճɹ���");
							}else{
								System.out.println("����ϵͳǩ��ʧ�ܣ�");
							}
						
						//ϵͳǩ��20140721
							
							
						} // for end
						rcvOK = true;// false;	
						

						if (rcvOK) {
							// System.out.println("if (rcvOK) {");
							docExchApi.setReceiveDocumentResult(exchId,DocExchangeApi.RECEIVE_DOCUMENT_OK);
						} else {
							docExchApi.setReceiveDocumentResult(exchId,DocExchangeApi.RECEIVE_DOCUMENT_ERROR);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						//������Ϣ����
						try{
							if(checkInterval()){
								sendMail(ex.getMessage());
								createSendSmsForm(ex.getMessage());
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				if(al.size() > 0){
					System.out.println("��ʼ��¼�����������");
					checkTodaySw(al);
					System.out.println("��¼���������������");
				}
				System.out.println("�����յ����н����ļ�" + docs.length + "��");
				// System.out.println("���յ����н����ļ������ĵ�λ��" + SWDW );
			} else {
				System.out.println("û����Ҫ���յ����н����ļ���");
			}
		} catch (Exception e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			//������Ϣ����
			try{
				if(checkInterval()){
					sendMail(e.getMessage());
					createSendSmsForm(e.getMessage());
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * ����������
	 * @param al
	 * @return
	 * 
	 */
	public boolean checkTodaySw(ArrayList al){
		Document cDoc = null;
		View vDoc = null;
		try{

			String strDate = getStrDate(new Date());
			vDoc = db.getView("vCheckTodaySw");
			cDoc = vDoc.getDocumentByKey(strDate);
			if(cDoc == null){
				cDoc = db.createDocument();
				cDoc.replaceItemValue("form", "fCheckTodaySw");
				cDoc.replaceItemValue("tDate", strDate);				
			}
			Vector vTitle = cDoc.getItemValue("tTitle");
			Vector vSwTime = cDoc.getItemValue("tSwTime");
			Vector vQsStatus = cDoc.getItemValue("tQsStatus");
//			Vector vUnid = cDoc.getItemValue("tUnid");
			Vector vFwTime = cDoc.getItemValue("tFwTime");
			String strtmp = "";
			String[] arrtmp = null;
			String msg = "�յ� " + al.size() + " ����,�ļ�����";
			for(int i = 0;i < al.size();i++){
				strtmp = (String)al.get(i);
				arrtmp = strtmp.split("#");
				System.out.println("[checkTodaySw]strtmp=" + strtmp + "$$$arrtmpLength=" + arrtmp.length);
				if(i == 0) msg += arrtmp[0];
				else msg += "," + arrtmp[0];
				vTitle.add(arrtmp[0]);
				vFwTime.add(arrtmp[1]);
				vSwTime.add(arrtmp[2]);
				vQsStatus.add(arrtmp[3]);
//				vUnid.add(arrtmp[4]);
			}
			cDoc.replaceItemValue("tTitle", vTitle);
			cDoc.replaceItemValue("tFwTime", vFwTime);
			cDoc.replaceItemValue("tSwTime", vSwTime);
//			cDoc.replaceItemValue("tUnid", vUnid);
			cDoc.replaceItemValue("tQsStatus", vQsStatus);
			cDoc.save();

			Vector senduser = new Vector();
			senduser.add("֣��ϼ/newgzga");
			mailSend(senduser,msg);
			
			return true;
		}catch(Exception e){
			System.out.println("checkTodaySw���ִ���");
			e.printStackTrace();
		}finally{
			try{
				if(cDoc != null) cDoc.recycle();
				if(vDoc != null) vDoc.recycle();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return false;
	}
	
	/***
	 * ��鷢�Ͷ��ŵļ���Ƿ��Ѿ��ﵽ1Сʱ����
	 * @return
	 */
	public boolean checkInterval(){
		Document prodoc = null;
		View view = null;
		try{
			view = db.getView("vfStgwtime");
			prodoc = view.getFirstDocument();
			if(prodoc == null){
				prodoc = db.createDocument();
				prodoc.replaceItemValue("form","fStgwtime");
			}			
			String sm = prodoc.getItemValueString("sendtime");			
			if (sm.equals("")){
				prodoc.replaceItemValue("sendtime", getStrTime(new Date()));
				prodoc.save();
				return true;
			}else{
				System.out.println("�ϴη���ʱ�䣺" + sm);
				String curTime = getStrTime(new Date());
				String prevTime = sm;
				String strtmp = "";
				Vector vetmp = session.evaluate("@Adjust(@TextToTime('" + curTime + "') ; 0 ; 0 ; 0 ; -1 ; 0 ; 0)");
				strtmp = vetmp.get(0).toString();
				strtmp = strtmp.substring(0,strtmp.indexOf(" ZE8"));
				System.out.println("vetmp=" + strtmp);
				String curTime1 = strtmp.trim();
				if (compare_date(curTime1,prevTime) == 1){
					prodoc.replaceItemValue("sendtime", getStrTime(new Date()));
					prodoc.save();
					return true;
				}else return false;
			}			
		}catch(Exception e){
			System.out.println("checkInterval���ִ���");
			e.printStackTrace();
		}finally{
			try{
				if(prodoc != null) prodoc.recycle();
				if(view != null) view.recycle();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * �Ƚ��������ڵĴ�С��date1 ���� date2 �ķ���1��С�ڵķ���-1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public  int compare_date(String date1,String date2){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		try{
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if((dt1.getTime() - dt2.getTime()) > 0){
				dt1 = null;
				dt2 = null;
				return 1;
			}else {
				dt1 = null;
				dt2 = null;
				return -1;
			}
		}catch(Exception e){
			System.out.println("compare_date���ִ���");
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * �����ִ���ʱ����Ҫ�Ѵ�����Ϣ���͸������Ա
	 */
	
	public void sendMail(String meg){
		Document memodoc = null;
		Document pzdoc = null;
		View view = null;
		Database pzdb = null;
		System.out.println("���Ĺ��Ľ���-�ʼ����Ϳ�ʼ");
		try{
			
			memodoc = db.createDocument();
			memodoc.replaceItemValue("form", "memo");			
			memodoc.replaceItemValue("sendto", this.vEmail);			
			memodoc.replaceItemValue("subject", "���Ĺ��Ľ�����ʡ�����Ĵ��������󣬴�����Ϣ��" + meg);
			
			//�����ʼ�
						
			memodoc.send(); 
			System.out.println("���Ĺ��Ľ���-�ʼ����ͽ���");
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(memodoc != null) memodoc.recycle();
				if(pzdoc != null) pzdoc.recycle();
				if(view != null) view.recycle();
				if(pzdb != null) pzdb.recycle();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * �����ʼ��������Ա
	 */
	
	public void mailSend(Vector sendto,String meg){
		Document memodoc = null;
		System.out.println("���Ĺ��Ľ���-�����ʼ���ʼ");
		try{
			//
			memodoc = db.createDocument();
			memodoc.replaceItemValue("form", "memo");			
			memodoc.replaceItemValue("sendto", sendto);			
			memodoc.replaceItemValue("subject", meg);
			
			//���Ͷ���
						
			memodoc.send(); 
			System.out.println("���Ĺ��Ľ���-�����ʼ�����");
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(memodoc != null) memodoc.recycle();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public boolean createSendSmsForm(String meg){
		System.out.println("���Ľ���-�����ſ�ʼ");
		Database smsdb = null;
		Document smsdoc = null;
		try{
			Vector vSendTo = new Vector(),vMobile = this.vPhone;
			
			Date date = new Date();
			String strtmp = "";
			for(int i = 0;i < this.vUname.size();i++){
				strtmp = (String)vMobile.get(i); 
				if (!strtmp.equals("Null")){
					vSendTo.add((String)this.vUname.get(i) + "=>" + (String)this.vPhone.get(i));					
				}
			}			
			
			smsdb = session.getDatabase(db.getServer(), "public/oasms.nsf", false);
			System.out.println("db=" + smsdb.getFilePath());
			
			smsdoc = smsdb.createDocument();
			smsdoc.replaceItemValue("Form","FormMessage");
			smsdoc.replaceItemValue("MessageContent","���Ĺ��Ľ�����ʡ�����Ĵ������б���������Ϣ��" + meg);
			smsdoc.replaceItemValue("Accepter",vSendTo);
			smsdoc.replaceItemValue("AccepterMobiles",vMobile);
			smsdoc.replaceItemValue("SendStatus","δ����");
			smsdoc.replaceItemValue("Sender","ϵͳ����Ա");
			smsdoc.replaceItemValue("MessageType","��������");
			smsdoc.replaceItemValue("SendType","��ʱ����");
			
			smsdoc.replaceItemValue("PlanSendDate",getYear(date) + "-" + getMonth(date) + "-" + getDay(date));
			smsdoc.replaceItemValue("PlanSendTime",getHMS(date));
			smsdoc.replaceItemValue("UnitName","ϵͳ");
			smsdoc.save();
			date = null;
			System.out.println("���Ľ���-�����Ž���");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try{
				if(smsdoc != null) smsdoc.recycle();
				if(smsdb != null) smsdb.recycle();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	//��ȡ���͵�������Ϣ
	public boolean getSendInfo(){
		Database pzdb = null;
		View view = null;
		Document pzdoc = null;
		try{
			//��ȡ������Ϣ
			String svr = "newicsvr-gzs/newgzga";
			String path = "public";
			pzdb = session.getDatabase(svr, path + "/xtpzst.nsf");
			if(pzdb == null)	System.out.println("�Ҳ����������ݿ�");
			view = pzdb.getView("vZxgwbctz");
			if(view == null)	System.out.println("�Ҳ���������ͼ");
			pzdoc = view.getFirstDocument();
			if(pzdoc == null)	System.out.println("�Ҳ��������ļ�");
			this.vUname = pzdoc.getItemValue("tUname_0");
			this.vPhone = pzdoc.getItemValue("tPhoneNum_0");
			this.vEmail = pzdoc.getItemValue("tEmailAddress_0");
			return true;
		}catch(Exception e){
			e.printStackTrace();			
		}finally{
			try{
				if(pzdoc != null) pzdoc.recycle();
				if(view != null) view.recycle();
				if(pzdb != null) pzdb.recycle();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public String getHjcd(String hjcd)
	// ��ȡ���Ľ����̶�
	{
		String temp = "";
		if (hjcd.equals("0")) {
			temp = "ƽ��";
		}
		if (hjcd.equals("1")) {
			temp = "����";
		}
		if (hjcd.equals("2")) {
			temp = "����";
		}
		if (hjcd.equals("3")) {
			temp = "�ؼ�";
		}
		if (hjcd.equals("4")) {
			temp = "����";
		}
		return temp;
	}

	public String getGwlx(String gwlx)
	// ��ȡ��������
	{
		String temp = "";
		if (gwlx.equals("0")) {
			temp = "��ί����";
		}
		if (gwlx.equals("1")) {
			temp = "�������ع���";
		}
		if (gwlx.equals("2")) {
			temp = "�������ع���";
		}
		return temp;
	}
	/**
	 * ��ȡ�ַ����͵Ĵ����������
	 * @param date
	 * @return
	 */
	public String getStrTime(Date date){
		try{
		String temp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		temp = sdf.format(date);
		// temp="";
		return temp;
		}catch(Exception e){
			System.out.println("getStrTime���ִ���");
			e.printStackTrace();
		}
		return "";
	}
	public String getStrDate(Date date){
		try{
			String temp = "";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			temp = sdf.format(date);
			// temp="";
			return temp;
		}catch(Exception e){
			System.out.println("getStrDate���ִ���");
			e.printStackTrace();			
		}
		return "";
	}
	public String getYear(Date date)
	// ��ȡ���
	{
		String temp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		temp = sdf.format(date);
		// temp="";
		return temp;
	}

	public String getMonth(Date date)
	// ��ȡ�·�
	{
		String temp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		temp = sdf.format(date);
		// temp="";
		if (temp.length() == 1) {
			temp = "0" + temp;
		}
		return temp;
	}

	public String getDay(Date date)
	// ��ȡ��
	{
		String temp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		temp = sdf.format(date);
		// temp="";
		if (temp.length() == 1) {
			temp = "0" + temp;
		}
		return temp;
	}
	//��ȡʱ����
	public String getHMS(Date date){
		String temp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		temp = sdf.format(date);
		
		return temp;
	}
	


	

	/**
	 * ���ֽ����鱣��Ϊһ���ļ�
	 */
	public static File getFileFromBytes(byte[] b, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return file;
	}
}
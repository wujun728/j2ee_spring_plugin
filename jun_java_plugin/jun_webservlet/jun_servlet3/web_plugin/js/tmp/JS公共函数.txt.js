// JScript �ļ�
/*
==================================================================

JS ��������
�����ռ� +  Ӱ�ӹ��� 

                         080827
============================================================
*/
/*
==================================================================
���ܣ�
============================================================
*/
function IfShow(ShowMsg)
{
 if (ShowMsg == "" )
 {
  return false;
 }
 else
 {
  return true;
 }
 
} 
/*
==================================================================
���ܣ��滻�ո񣨽���������ո��滻Ϊһ���ո�
ʹ�ã�ReplaceSpace(obj) 
���أ�string
==================================================================
*/
function ReplaceSpace(str)
{ 
 while ( str.indexOf("  ") >= 0 )
 {
  str = str.replace("  " ," ");
 }
 return str;
} /*
==================================================================
���ܣ��ǿռ�飬�����Կո�
��ʾ��Ϣ�������Ϊ�գ������룡
ʹ�ã�isNull(obj,string) 
���أ�bool
==================================================================
*/
function isNull(obj,ShowMsg) 
{
 var show = IfShow(ShowMsg) ;  //�ǿռ��
 if(obj.value == "")
 {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();  
  return false;
 }
 else
 {
  return true;
 }
} /*
==================================================================
���ܣ������ַ���
��ʾ��Ϣ��δ�����ʼ���ַ���ʼ���ַ��Ч��
ʹ�ã�MailCheck(obj,string)
���أ�bool
==================================================================
*/
function MailCheck(obj,ShowMsg)
{
 var show = IfShow(ShowMsg) ;
 
 if(obj.value!= "")
 {
  var ok1=obj.value.indexOf("@");
  var ok2=obj.value.indexOf(".");
  if(!((ok1!=-1)&&(ok2!=-1)))
  {
   if (show) alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;
  }
  var allowstrlist = "&#%<>";
  var endvalue = true;
  for (i=0;i<obj.value.length;i++) 
  {
   if (allowstrlist.indexOf(obj.value.substr(i,1))!=-1) 
   {
    endvalue=false;   
    break;
   }
  }
  if(endvalue==false)
  {
   if (show) alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;   
  }
  //�ʼ���ַ��ȷ
  return true;
 }
 else
 {
  //��������������ַ
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
  return false;
 }
} /*
==================================================================
���ܣ����������Ƿ�Ϊ����
��ʾ��Ϣ��δ���������Ĳ���һ���Ϸ������֣�
ʹ�ã�isNumeric(obj,string)
���أ�bool
==================================================================
*/
function isNumeric(obj,ShowMsg)
{ 
 var show = IfShow(ShowMsg) ;
 
 var IfTrue = obj.value.search(/^(-|\+)?\d+(\.\d+)?$/) != -1;
 
 if (show && IfTrue ==false)
 { 
  alert(ShowMsg);
  obj.focus();
  obj.select();
  return false;
 } 
 else
 {
  return true;
 }
} 
/*
==================================================================
���ܣ���ӡ
ʹ�ã�Print()
���أ�
==================================================================
*/
function Print()
{  document.all.print.style.display = "none";
 window.print();
 window.close();
} /*

==================================================================
���ܣ���֤���֤�����Ƿ���Ч
��ʾ��Ϣ��δ������������֤�Ų���ȷ��
ʹ�ã�isIDno(obj,string)
���أ�bool
==================================================================
*/
function isIDno(obj,ShowMsg)
{
 var show = IfShow(ShowMsg);
 
 //aCity={11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",21:"����",22:"����",23:"������ 
",31:"�Ϻ�",32:"����",33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",42:"����
",43:"����",44:"�㶫",45:"����",46:"����",50:"����",51:"�Ĵ�",52:"����",53:"����",54:"����
",61:"����",62:"����",63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����
"};
 var aCity = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51
,52,53,54,61,62,63,64,65,71,81,82,91"
 
 var iSum = 0;
 var info = "";
 var idCardLength = obj.value.length;  
if(!/^\d{17}(\d|x)$/i.test(obj.value)&&!/^\d{15}$/i.test(obj.value)) 
 {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
  return false;
 }
 
 //�ں����������x�൱������10,����ת����a
 obj.value = obj.value.replace(/x$/i,"a");
 
 var curCity = obj.value.substr(0,2);  if(!(aCity.indexOf(curCity) > 0) )
 {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
  return false;
 }  if (idCardLength==18)
 {
  
sBirthday=obj.value.substr(6,4)+"-"+Number(obj.value.substr(10,2))+"-"+Number(obj.value.subs
tr(12,2));
  var d = new Date(sBirthday.replace(/-/g,"/"))
  if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))
  {
   if (show) 
    alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;
  }
 
  for(var i = 17;i>=0;i --)
  iSum += (Math.pow(2,i) % 11) * parseInt(obj.value.charAt(17 - i),11);
 
  if(iSum%11!=1)
  {
   if (show) 
    alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;
  }
 
 }
 else if (idCardLength==15)
 {
  sBirthday = "19" + obj.value.substr(6,2) + "-" + Number(obj.value.substr(8,2)) + "-" + 
Number(obj.value.substr(10,2));
  var d = new Date(sBirthday.replace(/-/g,"/"))
  var dd = d.getFullYear().toString() + "-" + (d.getMonth()+1) + "-" + d.getDate();   
if(sBirthday != dd)
  {   
   if (show) 
    alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;
  }
 }
 return true; 
} 
/*
==================================================================
���ܣ���֤�绰�����ʽ�Ƿ���ȷ
��ʾ��Ϣ��δ���������绰�����ʽ����ȷ��
ʹ�ã�isPhoneNo(obj,string)
���أ�bool
==================================================================
*/
function isPhoneNo(obj,ShowMsg)
{
 var show = IfShow(ShowMsg);
 
 var phoneNo = obj.value;
 var Endvalue = true;
 var allowstrlist = "1234567890()-";
 if(phoneNo!="")
 {   
  for (i=0;i<phoneNo.length;i++) 
  {
    if (allowstrlist.indexOf(phoneNo.substr(i,1)) == -1) 
    {
   Endvalue = false;   
   break;
    }
  }
  if(Endvalue == false)
  {
   if (show) 
    alert(ShowMsg);
   obj.focus();
   obj.select();
   return false;
  }
 }
 else
 {
  if (show) 
    alert(ShowMsg);
  obj.focus();
  obj.select();
  return false;
 }
 return true;
}
/*
==================================================================
���ܣ��ж��Ƿ�Ϊ������������������������������������+0����������+0     
��ʾ��Ϣ���������������Ĳ���һ����������������
ʹ�ã�isFloat(obj,string,int or string,string)
       (���Զ���,+ or - or empty,empty or 0,��ʾ��Ϣ)
��������       
     ��  ������
     +   ��������
     -   ��������
���أ�bool
==================================================================
*/
function isFloat(obj,sign,zero,ShowMsg)
{
 var show = IfShow(ShowMsg);
 
 var objStr = obj.value;
    var reg;    
    var bolzero;    
    
    if(Trim(objStr)=="")
    {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
        return false;
    }
    else
    {
        objStr=objStr.toString();
    }    
    
    if((sign==null)||(Trim(sign)==""))
    {
        sign="+-";
    }
    
    if((zero==null)||(Trim(zero)==""))
    {
        bolzero=false;
    }
    else
    {
        zero=zero.toString();
        if(zero==0)
        {
            bolzero=true;
        }
        else
        {
            if (show) alert(ShowMsg);
            obj.focus();
  obj.select();
            return false;
        }
    }
    
    switch(sign)
    {
        case "+-":
            //������
            reg=/^((-?|\+?)\d+)(\.\d+)?$/;
            break;
        case "+": 
            if(!bolzero)           
            {
                //��������  
reg=/^\+?(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
            }
            else
            {
                //��������+0
                reg=/^\+?\d+(\.\d+)?$/;
            }
            break;
        case "-":
            if(!bolzero)
            {
                //��������                
    reg=/^-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
            }
            else
            {
                //��������+0
                reg=/^((-\d+(\.\d+)?)|(0+(\.0+)?))$/;
            }            
            break;
        default:
            if (show) alert(ShowMsg);
            obj.focus();
  obj.select();
            return false;
            break;
    }
    
    var r=objStr.match(reg);
    if(r==null)
    {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
        return false;
    }
    else
    {        
        return true;     
    }
} 
/*
==================================================================
���ܣ��ж��Ƿ�Ϊ����������������������������+0��������+0
��ʾ��Ϣ���������������Ĳ���һ��������������
ʹ�ã�isInt(obj,string,int or string,string)
     (���Զ���,+ or - or empty,empty or 0,��ʾ��Ϣ)
     ��  ����
     +   ������
     -   ������
���أ�bool
==================================================================
*/
function isInt(obj,sign,zero,ShowMsg)
{
 var show = IfShow(ShowMsg);
 
 var objStr = obj.value;
 
    var reg;    
    var bolzero;    
    
    if(Trim(objStr)=="")
    {  
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
        return false;
    }
    else
    {
        objStr=objStr.toString();
    }    
    
    if((sign==null)||(Trim(sign)==""))
    {
        sign="+-";
    }
  &nbsp; 
    if((zero==null)||(Trim(zero)==""))
    {
        bolzero=false;
    }
    else
    {
        zero=zero.toString();
        if(zero==0)
        {
            bolzero=true;
        }
        else
        {
            if (show) alert(ShowMsg);
            obj.focus();
   obj.select();
            return false;
        }
    }
    
    switch(sign)
    {
        case "+-":
            //����
            reg=/(^-?|^\+?)\d+$/;            
            break;
        case "+": 
            if(!bolzero)           
            {
                //������
                reg=/^\+?[0-9]*[1-9][0-9]*$/;
            }
            else
            {
                //������+0
                //reg=/^\+?\d+$/;
                reg=/^\+?[0-9]*[0-9][0-9]*$/;
            }
            break;
        case "-":
            if(!bolzero)
            {
                //������
                reg=/^-[0-9]*[1-9][0-9]*$/;
            }
            else
            {
                //������+0
                //reg=/^-\d+$/;
                reg=/^-[0-9]*[0-9][0-9]*$/;
            }            
            break;
        default:
            if (show) alert(ShowMsg);<BR>            obj.focus();
   obj.select();
            return false;
            break;
    }
    
    var r=objStr.match(reg);
    if(r==null)
    {
  if (show) alert(ShowMsg);
  obj.focus();
  obj.select();
        return false;
    }
    else
    {    
        return true;     
    }
}
/*
==================================================================
���ܣ��ַ�������,ȥ���ַ������ߵĿո�
ʹ�ã�LTrim(string) 
���أ�string
 ==================================================================
            */
            function LTrim(str)
            {
                var whitespace = new String(" \t\n\r");
                var s = new String(str);
                
                if (whitespace.indexOf(s.charAt(0)) != -1)
                {
                    var j=0, i = s.length;
                    while (j < i && whitespace.indexOf(s.charAt(j)) != -1)
                    {
                        j++;
                    }
                    s = s.substring(j, i);
                }
                return s;
            }
             
            /*
            ==================================================================
            ���ܣ�ȥ���ұߵĿո�
            ʹ�ã�RTrim(string)
   ���أ�string
            ==================================================================
            */
            function RTrim(str)
            {
                var whitespace = new String(" \t\n\r");
                var s = new String(str);
             
                if (whitespace.indexOf(s.charAt(s.length-1)) != -1)
                {
                var i = s.length - 1;
                    while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1)
                    {
                        i--;
                    }
                    s = s.substring(0, i+1);
                }
                return s;
            }
            
//ȥ��ǰ��ո�            
function Trim(str)
{
    return RTrim(LTrim(str));
}             
/*
==================================================================
���ܣ���Ч�ַ��ļ�⣨���������������ַ���
��ʾ��Ϣ��δ�������������Ƿ��ַ�
ʹ�ã�CheckChar(obj,Lchar,string)
   Lchar��Ҫ���������ַ�
���أ�bool
==================================================================
*/
function CheckChar(obj,Lchar,ShowMsg)
{
 var show = IfShow(ShowMsg);  var strlist = Lchar; //"\"\ >~!@#$%^&*?<>\"\ ";
 
 //��Ч�ַ��ļ�� 
 if(obj.value!= "")
 {  
  var tmpbool=true;
  for (i=0;i<obj.value.length;i++)
  {
   if(strlist.indexOf(obj.value.substr(i,1))!=-1)
   {
    tmpbool=false;
    break;
   }
   else
   {}
  }
  
  if(tmpbool==false)
  {
   if (show) alert(ShowMsg + strlist);
   obj.focus();
   obj.select();
   return false;
  }
  else
  {
   return true;
  }
 }
 else
 {
  if (show) alert(ShowMsg + strlist);
  return false;
 }
  
}  
/*
==================================================================
���ܣ��ж��Ƿ�Ϊ����(��ʽ:yyyy-mm-dd)
��ʾ��Ϣ��δ�������������ڸ�ʽ����
ʹ�ã�isDate(obj,string)
���أ�bool
==================================================================
*/
function isDate(obj,ShowMsg)
{
 var show = IfShow(ShowMsg) ;
 
 if(obj.value==null)
 {
 if (show) alert(ShowMsg);
 return false;
 }
 
    if(obj.value=="")
    {
 if (show) alert(ShowMsg);
 return false;
 }
    
    var datePat=/^(\d{2}|\d{4})(\-)(\d{1,2})(\-)(\d{1,2})$/;
    
    var dateStr=obj.value;
    // is the format ok?
 var matchArray = dateStr.match(datePat); 
    if (matchArray==null)
    {
  if (show) alert(ShowMsg);
        return false;
    }
    year=matchArray[1];
    month=matchArray[3];
    day=matchArray[5];     if (year.length!=4 || month.length!=2 || day.length!=2)
    {
  if (show) alert(ShowMsg);
        return false;
    }
    if (month < 1 || month > 12)
    {
  if (show) alert(ShowMsg);
        return false;
    }
    if (day < 1 || day > 31)
    {
  if (show) alert(ShowMsg);
        return false;
    }     if ((month==4 || month==6 || month==9 || month==11) && day==31)
    {
  if (show) alert(ShowMsg);
        return false;
    }     if (month==2)
    {
        var isleap=(year % 4==0 && (year % 100 !=0 || year % 400==0));
        if (day>29 || ((day==29) && (!isleap)))
        {
   if (show) alert(ShowMsg);
            return false;
        }
    }
    return true;
} /*
==================================================================
���ܣ����ڴ�С�ж�(��ʽ��yyyy-mm-dd)
��ʾ��Ϣ��δ���������Ŀ�ʼ���ڴ��ڽ������ڣ�
ʹ�ã�JudgeDate(obj1,obj2,string)
���أ�bool
==================================================================
*/
function JudgeDate(obj1,obj2,ShowMsg)
{
 var show = IfShow(ShowMsg) ;
 
 var eva = isDate(obj1,"") && isDate(obj2,"");
 
    if(obj1.value!="" && obj2.value!="" & eva != false)
    {
  var date1 = obj1.value;
        var myDate1 = Date.parse(date1.replace("-","/"));
        var date2 = obj2.value;
        var myDate2 = Date.parse(date2.replace("-","/"));
        if(myDate1 > myDate2)
        {
            if (show) alert(ShowMsg);
            return false;
        }
        else
        {
   return true;
        }
    }
    else
    {
  if (show) alert(ShowMsg);
  return false;
    }
}  
 

  
///////////////////////////
function setCopy(_sTxt){try{clipboardData.setData('Text',_sTxt);window.status=_sTxt+'�Ѿ����Ƶ�������'}catch(e){}}
function setHome(){try{window.external.AddFavorite(window.document.location,window.document.title)}catch(e){};}
function $(d){try{return document.getElementById(d);}catch(e){return null;}}

function marquees(view,src,cont){
var speed=50 ;
var _demo=$(view); var _demo1=$(src); var _demo2=$(cont); 
_demo2.innerHTML=_demo1.innerHTML+_demo1.innerHTML ;
function Marquee(){ 
if(_demo.offsetWidth<=_demo.scrollLeft){ 
_demo.scrollLeft=0
}else{ 
_demo.scrollLeft++ 
} 
//window.status=_demo.offsetWidth+','+_demo.scrollLeft;
} 
var MyMar=setInterval(Marquee,speed) ;
_demo.onmouseover=function() {clearInterval(MyMar)} 
_demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)} 
}

function xmlhttp(){
    try { return new ActiveXObject("Msxml2.XMLHTTP");    } catch(e) {}
    try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch(e) {}
    try { return new XMLHttpRequest();                   } catch(e) {}
	window.status='XMLHTTP error!'; return null;
}




function setText(http,out,isalert,callback){
	if(!isalert){
		if(out=='')out='mybody';
		
		var obj=document.getElementById(out);
		window.status='���������У����Ժ�... ...';
		obj.innerHTML='<p><img src=/img/loading.gif border=0 width=32 height=32 align=absmiddle>���������У����Ժ�... ...</P>';	
	}
	var s='';
	if (http.readyState == 4) {
		window.status='���';
		if(http.status ==200){s=unescape(http.responseText);}else{s='<p>������æ�����粻ͨ�����Ժ����ԡ�'+http.statusText+'<br>'+unescape(http.responseText)+'</p>';}	
		if(!isalert){obj.innerHTML=s;if(callback!=''){eval(callback);}
		}else{ if(s!=''){ if(callback!=''){eval(callback);}alert(s); } }
		delete http;
		http=null;
	}
}

//  a=1;b=2; �������ַ����з���a��ֵvar a=getValue(str,'a',';','=');
function getValue(str,v,s1,s2){
	str+=s1;
	var ary=str.split(s1);
	for(var i=0;i<ary.length;i++){
		if(ary[i].indexOf(s2)>=0){
			if(ary[i].split(s2)[0]==v){
				return ary[i].substring(ary[i].indexOf(s2)	+s2.length);
			}
		}	
	}
	return '';
}




function neverDragDivision(fObj) { with (this)
{
	if (!fObj) return;
	this.bDraged = false;
	this.oDragOrig = fObj;	
	oDragOrig.style.cursor = "move";
	oDragOrig.onmousedown = function()
	{
		var ofs = Offset(oDragOrig);
  	  oDragOrig.style.position = "absolute";
		oDragOrig.style.left = ofs.l;
		oDragOrig.style.top = ofs.t;
		oDragOrig.X = event.clientX - ofs.l;
		oDragOrig.Y = event.clientY - ofs.t;
		bDraged = true;
	};		
	//this.leftDiv=Offset(document.getElementById('left1'));
	oDragOrig.onmousemove = function()
	{
		if (!bDraged) return;
   		oDragOrig.setCapture();
		//window.status=leftDiv.l+';'+oDragOrig.X+':'+oDragOrig.Y+','+oDragOrig.style.left+':'+oDragOrig.style.top;
		var l= event.clientX - oDragOrig.X;
		var t = event.clientY - oDragOrig.Y;
		//if(Math.abs(l-leftDiv.l)<=50)l=150;
		oDragOrig.style.left=l; 
		oDragOrig.style.top=t;

	};
	oDragOrig.onmouseup = function()
	{
		bDraged = false;
		oDragOrig.releaseCapture();
	};
	function Offset(e) {
		var t = e.offsetTop;
		var l = e.offsetLeft;
		var w = e.offsetWidth;
		var h = e.offsetHeight;
		while(e=e.offsetParent) {
			t+=e.offsetTop;
			l+=e.offsetLeft;
		}
		return { t:t, l:l, w:w, h:h }
	};
}};

//ͼƬ����������
function changeImg(ImgD,iwidth,iheight){    
     var image=new Image();
     image.src=ImgD.src;
    if(image.width>0 && image.height>0){    
    if(image.width/image.height>= iwidth/iheight){
        if(image.width>iwidth){  
         ImgD.width=iwidth;
         ImgD.height=(image.height*iwidth)/image.width;
         }else{
         ImgD.width=image.width;  
         ImgD.height=image.height;
         }
         ImgD.alt=image.width+"��"+image.height;
         }
    else{
        if(image.height>iheight){  
         ImgD.height=iheight;
         ImgD.width=(image.width*iheight)/image.height;        
         }else{
         ImgD.width=image.width;  
         ImgD.height=image.height;
         }
         ImgD.alt=image.width+"��"+image.height;
         }
     }
} 


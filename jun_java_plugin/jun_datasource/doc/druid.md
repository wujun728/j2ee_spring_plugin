Druid���ܼ�����

1.ʲô��Druid��
Druid��һ����Ч�����ݲ�ѯϵͳ����Ҫ������Ƕ��ڴ����Ļ���ʱ������ݽ��оۺϲ�ѯ�����ݿ���ʵʱ���룬���뵽Druid�������ɲ飬ͬʱ�����Ǽ����ǲ��ɱ䡣ͨ���ǻ���ʱ�����ʵ�¼�����ʵ���������Druid���ⲿϵͳ�Ϳ��ԶԸ���ʵ���в�ѯ��
Druid���õļܹ�:
shared-nothing�ܹ���lambda�ܹ�
Druid�������ԭ��:
1.���ٲ�ѯ��Fast Query�� : �������ݾۺϣ�Partial Aggregate�� + �ڴ滪��In-Memory�� + ������Index��
2.ˮƽ��չ������Horizontal Scalability��:�ֲ�ʽ���ݣ�Distributed data��+���л���ѯ��Parallelizable Query��
3.ʵʱ������Realtime Analytics����Immutable Past , Append-Only Future

2.Druid�ļ����ص�
������������
֧����ʽ���������ʵʱ
��ѯ����ҿ���

3.Druid�������
Druid����������֮ǰ������Ҫ����һ������Դ��DataSource,���������ݿ��б�ĸ��
Druid��һ���ֲ�ʽ���ݷ���ƽ̨,Ҳ��һ��ʱ�����ݿ�
1.���ݸ�ʽ
���ݼ��ϣ�ʱ���У�ά���У�ָ���У�
���ݽṹ��
����DataSource��Segment�����ݽṹ��DataSource�൱�ڹ�ϵ�����ݿ��еı�
DataSource������
ʱ���У�TimeStamp������ʶÿ�����ݵ�ʱ��ֵ
ά���У�Dimension������ʶ�����еĸ��������Ϣ
ָ���У�Metric��:���ھۺϺͼ������
Segment�ṹ��
DataSource���߼��ṹ����Segment������ʵ�ʴ洢������ṹ��Druidͨ��Segmentʵ�ֶ����ݵĺ����и������
�����иͨ��������segmentGranularity������Druid����ͬʱ�䷶Χ�ڵ����ݴ洢�ڲ�ͬSegment���ݿ��С�
�����и��Segment�������н�������ѹ������

���ú����Granularity
segmentGranularity��segment��������ȡ�
queryGranularity ��segment�ľۺ����ȡ�
queryGranularity С�ڵ��� segmentGranularity
��segmentGranularity = day����ôDruid�ᰴ����Ѳ�ͬ������ݴ洢�ڲ�ͬ��Segment�С�
��queryGranularity =none,���Բ�ѯ�������ȣ�queryGranularity = hourֻ�ܲ�ѯ>=hour���ȵ�����

2.��������
ʵʱ��������
��������������

3.���ݲ�ѯ
ԭ����ѯ������JSON��ʽ��ͨ��http����

4.ʱ�����ݿ�
1.OpenTSDB
��Դ��ʱ�����ݿ⣬֧����ǧ�ڵ����ݵ㣬���ṩ��ȷ�����ݲ�ѯ����
����java��д��ͨ������Hbase�Ĵ洢ʵ�ֺ�����չ
���˼·������Hbase��key�洢һЩtag��Ϣ����ͬһСʱ�����ݷ���һ�д洢������˲�ѯ�ٶ�
�ܹ�ʾ��ͼ��

2.Pinot
�ӽ�Druid��ϵͳ
PinotҲ������Lambda�ܹ�����ʵʱ�������������ݷֿ�����
Realtime Node����ʵʱ���ݲ�ѯ
Historical Node������ʷ����
�����ص㣺
������ʽ�洢�����ݿ⣬֧�ֶ���ѹ������
�ɲ������������ �� Sorted index ��Bitmap index�� Inverted index
���Ը���Query��SegmentԪ���ݽ��в�ѯ��ִ�мƻ����Ż�
��kafkaʵʱ�������ݺʹ�hadoop���������ݹ���
������SQL�Ĳ�ѯ���Ժ͸��ֳ��þۺ�
֧�ֶ�ֵ�ֶ�
ˮƽ��չ���ݴ�
Pinot�ܹ�ͼ��

3.Druid�ܹ�����

Druid���������ĸ��ڵ㣺
ʵʱ�ڵ㣨Realtime ��:��ʱ����ʵʱ���ݣ��Լ�����Segment�����ļ�
ʵʱ�ڵ㸺������ʵʱ���ݣ�ʵʱ�������Ȼᱻֱ�Ӽ��ؽ�ʵʱ�ڵ��ڴ��еĶѽṹ������������������ʱ��
�����������ݻᱻ��д��Ӳ�����γ�һ�����ݿ飨Segment Split����ͬʱʵʱ�ڵ��ֻ������������ɵ����ݿ���ص��ڴ�ķǶ�����
��������Ƕѽṹ���������ǷǶ���������ݶ��ܱ���ѯ�ڵ㣨Broker Node����ѯ
��ʷ�ڵ�(Historical Node):�����Ѿ����ɺõ��ļ����Թ����ݲ�ѯ
��ѯ�ڵ�(Broker Node)�������ṩ���ݲ�ѯ���񣬲�ͬʱ��ʵʱ�ڵ����ʷ�ڵ��ѯ���ݣ��ϲ��󷵻ظ����÷�
Э���ڵ㣨Coordinator Node����������ʷ�ڵ�����ݸ��ؾ��⣬�Լ�ͨ������Rule���������ݵ���������

��Ⱥ�����������ⲿ����
Ԫ���ݿ⣨Metastore�����洢Druid��Ⱥ��ԭ������Ϣ������Segment�������Ϣ��һ����MySql��PostgreSQL
�ֲ�ʽЭ������Coordination��:ΪDruid��Ⱥ�ṩһ����Э������������ͨ��ΪZookeeper
�����ļ��洢ϵͳ��DeepStorage����������ɵ�Segment�ļ���������ʷ�ڵ����ء����ڵ��ڵ㼯Ⱥ�����Ǳ��ش��̣������ڷֲ�ʽ��Ⱥһ����HDFS��NFS

ʵʱ�ڵ����ݿ������ʾ��ͼ��


���ݿ������

Realtime Node ʵʱ�ڵ㣺
1.ͨ��Firehose������ʵʱ���ݣ�Firehose��Druid������ʵʱ���ݵ�ģ��
2.ʵʱ�ڵ��ͨ��һ����������Segment�����ļ���ģ��Plumber������ʵ����RealtimePlumber�ȣ�����ָ�������ڣ���ʱ���������������������ݿ�ϲ���һ�����Segment�ļ�

Historical Node��ʷ�ڵ�

��ʷ�ڵ���������ʱ�� ��
1����ȥ����Լ����ػ������Ѿ����ڵ�Segment�����ļ�
2����DeepStorege�����������Լ�����Ŀǰ�����Լ����ش����ϵ�Segment�����ļ�
���ۺ��ֲ�ѯ����ʷ�ڵ�����Ƚ����Segment�����ļ��Ӵ��̼��ص��ڴ棬Ȼ�����ṩ��ѯ

Broker Node�ڵ㣺
Druid�ṩ���������ΪCache�Թ�ѡ��
�ⲿCache,����Memcached
����Cache,�����ѯ�ڵ����ʷ�ڵ���ڴ���Ϊcache

�߿����ԣ�
ͨ��Nginx�����ؾ����ѯ�ڵ㣨Broker Node��


Э���ڵ㣺
Э���ڵ㣨Coordinator Node��������ʷ�ڵ�����ݸ��ؾ��⣬�Լ�ͨ������������ݵ���������

4.��������

1.�������ڵ㣺overlord
��������ģʽ��
����ģʽ��Local Mode����Ĭ��ģʽ�����ڵ㸺��Ⱥ������Э�����乤����Ҳ�ܹ���������һЩ�๤��Peon�������һ���־�������
Զ��ģʽ��Remote������ģʽ�£����ڵ���ӽڵ������ڲ�ͬ�Ľڵ��ϣ���������Ⱥ������Э�����乤������������ɾ�����������ڵ��ṩRESTful�ķ��ʷ�������˿ͻ��˿���ͨ��HTTP POST
���������ڵ��ύ����
�����ʽ���£�
http://<ioverlord_ip>:port/druid/indexer/v1/task
ɾ������http://<ioverlord_ip>:port/druid/indexer/v1/task/{taskId}/shutdown
����̨��http://<ioverlord_ip>:port/console.html

2.�ӽڵ㣺Middle Manager
��������Ĺ����ڵ㣬����������ڵ�ķ��������Ȼ��������صĿ๤��������JVM����ɾ��������
�����ļܹ���Hadoop YARN����
���ڵ��൱��Yarn��ResourceManager,����Ⱥ��Դ�������������
�ӽڵ��൱��Yarn��NodeManager,�����������ڵ����Դ����������
Peon(�๤)�൱��Yarn��Container,�����ھ���ڵ��ϸ�����������ִ��

���⣺
�����ϰ汾��Druidʹ��pull��ʽ����kafka���ݣ�ʹ��kafka consumer group����ͬ����һ��kafka topic�����ݣ������ڵ�Ḻ���������һ��������topic��������Partition���ݣ�����֤ͬһ��Partition���ᱻ����һ����ʵʱ�ڵ����ѡ�ÿ��һ��ʵʱ�ڵ���ɲ������ݵ����Ѻ󣬻����������ѽ��ȣ�kafka topic offset���ύ��Zookeeper��Ⱥ��
���ڵ㲻����ʱ����kafka consumer group �����������ڶ����п��õĽڵ����partition���·��䣬�������нڵ㽫����ݼ�¼��zk��Ⱥ��ÿһ��partition��offset����������δ�����ѵ����ݣ��Ӷ���֤�����������κ�ʱ�򶼻ᱻDruid��Ⱥ��������һ�Ρ�
������Ȼ�ܱ�֤�����ýڵ�δ���ѵ�partition�ᱻ���๤���Ľڵ����ѵ������ǲ����ýڵ����Ѿ����ѵ����ݣ���δ�����͵�DeepStoreage����δ����ʷ�ڵ����ص�Segment����ȴ�ᱻ��Ⱥ��©�����ǻ���kafka-eight Firehose���ѷ�ʽ��һ��ȱ�ݡ�
���������
1.�ò����ýڵ�ָ����»ص���Ⱥ��Ϊ���ýڵ㣬������Ὣ֮ǰ�Ѿ����ɵ�δ�ϴ���Segment�����ļ�ͳͳ���ػ����������պϲ����͵�DeepStoreage����֤����������
2.ʹ��Tranquility��Indexing Service,��kafka�����ݽ��о�ȷ�������뱸�ݡ�
����Tranquility����ͨ��push�ķ�ʽ��ָ����������Druid��Ⱥ�����������ͬʱ��ͬһ��partition���������������Ե�ĳ����������ʧ��ʱ��ϵͳ��Ȼ����׼ȷ��ѡ��ʹ������һ����ͬ��������������Segment���ݿ�
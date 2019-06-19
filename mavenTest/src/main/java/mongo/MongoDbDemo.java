package mongo;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author zhuliang
 * @date 2019/6/6 15:32
 */
public class MongoDbDemo {
    public static void main(String[] args) {
        //连接mongodb服务器
        MongoClient client = new MongoClient("192.168.238.128");
        //得到要操作的数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //得到集合中所有的文档
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println("content : " + document.getString("content"));
            System.out.println("userid : " + document.getString("userid"));
            System.out.println("visits : " + document.getInteger("visits"));
        }
        client.close();
    }
}

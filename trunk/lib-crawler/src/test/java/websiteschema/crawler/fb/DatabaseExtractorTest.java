/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package websiteschema.crawler.fb;

import org.junit.Test;

/**
 *
 * @author ray
 */
public class DatabaseExtractorTest {

    @Test
    public void test() {
        FBDatabaseExtractor ext = new FBDatabaseExtractor();
        ext.jdbcUrl = "jdbc:mysql://192.168.4.38:3306/weibo";
        ext.jdbcDriver = "com.mysql.jdbc.Driver";
        ext.username = "cpp1";
        ext.password = "cpp1";
        ext.sql = "select id, AuthorName AUTHOR, AuthorUrl AUTHOR_URL, WeiboText DRECONTENT, DATE_FORMAT(FROM_UNIXTIME(PublishTime/1000), '%Y-%m-%d %H:%i:%S') PUBLISHDATE, ForwardCount FORWARD_COUNT, CommentCount COMMENT_COUNT, Website SOURCEINFO, KeyMd5 DREREFERENCE from Results_sina where Flag=1 limit 0, 1";
        ext.updateSQL = "update Results_sina set Flag=0";
        ext.pk = "id";
        ext.execute();
    }
}

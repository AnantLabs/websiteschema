/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Feb 22, 2012, 6:21:05 PM
 */
package websiteschema.analyzer.browser.tools;

import java.util.Map;
import org.w3c.dom.Document;
import websiteschema.cluster.DocumentConvertor;
import websiteschema.crawler.Crawler;
import websiteschema.crawler.WebPage;
import websiteschema.element.DocumentUtil;
import websiteschema.element.XPathAttributes;
import websiteschema.model.domain.cluster.DocUnits;
import websiteschema.model.domain.cluster.Unit;
import websiteschema.utils.StringUtil;

/**
 *
 * @author ray
 */
public class CrawlerTestFrame extends javax.swing.JFrame {

    XPathAttributes xpathAttr;

    /** Creates new form NewJFrame */
    public CrawlerTestFrame() {
        initComponents();

        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.getWidth();
        int sizeHeight = this.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);

        this.setTitle("工具 - 抽取器测试");
    }

    public void setUrl(String url) {
        if (null != url && !url.isEmpty()) {
            this.urlField.setText(url);
        }
    }

    public void setXPathAttr(XPathAttributes xpathAttr) {
        this.xpathAttr = xpathAttr;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        crawlerCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        charsetCombo = new javax.swing.JComboBox();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        httpStatusLabel = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        userAgentField = new javax.swing.JTextField();
        jToolBar5 = new javax.swing.JToolBar();
        jLabel6 = new javax.swing.JLabel();
        cookieField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        docSourceArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        domArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        unitArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        jLabel1.setText("http://");
        jToolBar1.add(jLabel1);
        jToolBar1.add(urlField);

        goButton.setText("Go");
        goButton.setFocusable(false);
        goButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(goButton);

        jToolBar2.setRollover(true);

        jLabel3.setText("采集器:");
        jToolBar2.add(jLabel3);

        crawlerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HTTP", "HtmlUnit", "Webrenderer" }));
        jToolBar2.add(crawlerCombo);

        jLabel2.setText("编码:");
        jToolBar2.add(jLabel2);

        charsetCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Detect", "UTF-8", "GBK" }));
        jToolBar2.add(charsetCombo);

        jToolBar3.setRollover(true);

        jLabel4.setText("HttpStatus: ");
        jToolBar3.add(jLabel4);
        jToolBar3.add(httpStatusLabel);

        jToolBar4.setRollover(true);

        jLabel5.setText("User-Agent: ");
        jToolBar4.add(jLabel5);
        jToolBar4.add(userAgentField);

        jToolBar5.setRollover(true);

        jLabel6.setText("Cookie: ");
        jToolBar5.add(jLabel6);
        jToolBar5.add(cookieField);

        docSourceArea.setColumns(20);
        docSourceArea.setRows(5);
        jScrollPane1.setViewportView(docSourceArea);

        jTabbedPane1.addTab("源代码", jScrollPane1);

        domArea.setColumns(20);
        domArea.setRows(5);
        jScrollPane2.setViewportView(domArea);

        jTabbedPane1.addTab("DOM", jScrollPane2);

        unitArea.setColumns(20);
        unitArea.setRows(5);
        jScrollPane3.setViewportView(unitArea);

        jTabbedPane1.addTab("Unit序列", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        new Thread(new Runnable() {

            @Override
            public void run() {
                go();
            }
        }).start();
    }//GEN-LAST:event_goButtonActionPerformed

    private void go() {
        this.goButton.setEnabled(false);
        try {
            this.docSourceArea.setText("");
            this.domArea.setText("");
            Crawler crawler = createCrawler();
            if (null != crawler) {
                crawler.setEncoding(getCharset());
                String cookie = getCookie();
                if (StringUtil.isNotEmpty(cookie)) {
                    crawler.setCookie(cookie);
                }
                String userAgent = getUserAgent();
                if (StringUtil.isNotEmpty(userAgent)) {
                    crawler.addHeader("User-Agent", userAgent);
                }

                WebPage page = crawler.crawlWebPage(getURL());
                Document docs[] = page.getDocs();
                if (null != docs && docs.length > 0) {
                    for (Document doc : docs) {
                        this.domArea.append(DocumentUtil.getXMLString(doc));//显示DOM
                    }
                    setUnits(docs[0]);//显示Unit序列
                }
                String sources[] = page.getHtmlSource();
                if (null != sources && sources.length > 0) {
                    for (String source : sources) {
                        this.docSourceArea.append(source + "\n---------------------------\n");//显示源代码
                    }
                }

                int httpStatus = crawler.getHttpStatus();
                this.httpStatusLabel.setText(String.valueOf(httpStatus));
            }
        } catch (Exception ex) {
            this.docSourceArea.append("\n(T_T)\n" + ex.getMessage());
        } finally {
            this.goButton.setEnabled(true);
        }
    }

    private void setUnits(Document doc) {
        if (null != xpathAttr) {
            DocumentConvertor docConvertor = new DocumentConvertor();
            docConvertor.setXpathAttr(xpathAttr);
            DocUnits docUnits = docConvertor.convertDocument(doc);
            Unit[] units = docUnits.getUnits();
            if (null != units) {
                for (Unit unit : units) {
                    Map<String, String> attr = unit.getAttributes();
                    this.unitArea.append(unit.getXpath() + " -> " + unit.getText().trim());
                    if (null != attr) {
                        this.unitArea.append(" | " + attr + "\n");
                    } else {
                        this.unitArea.append("\n");
                    }
                }
                this.unitArea.setCaretPosition(0);
            }
        } else {
            this.unitArea.append("无效的XPath Attributes");
        }
    }

    private Crawler createCrawler() {
        String sel = (String) this.crawlerCombo.getSelectedItem();
        if ("HTTP".equalsIgnoreCase(sel)) {
            return createCrawler("websiteschema.crawler.SimpleHttpCrawler");
        } else if ("HtmlUnit".equalsIgnoreCase(sel)) {
            return createCrawler("websiteschema.crawler.htmlunit.HtmlUnitWebCrawler");
        } else if ("Webrenderer".equalsIgnoreCase(sel)) {
            return createCrawler("websiteschema.crawler.browser.BrowserWebCrawler");
        }

        return null;
    }

    private Crawler createCrawler(String className) {
        try {
            Class clazz = Class.forName(className);
            Crawler ret = (Crawler) clazz.newInstance();
            return ret;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String getCharset() {
        if (this.charsetCombo.getSelectedIndex() > 0) {
            return (String) this.charsetCombo.getSelectedItem();
        } else {
            return null;
        }
    }

    private String getURL() {
        String ret = this.urlField.getText().trim();
        if (!ret.startsWith("http://")) {
            ret = "http://" + ret;
        }

        return ret;
    }

    private String getCookie() {
        return cookieField.getText();
    }

    private String getUserAgent() {
        return userAgentField.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox charsetCombo;
    private javax.swing.JTextField cookieField;
    private javax.swing.JComboBox crawlerCombo;
    private javax.swing.JTextArea docSourceArea;
    private javax.swing.JTextArea domArea;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel httpStatusLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JTextArea unitArea;
    private javax.swing.JTextField urlField;
    private javax.swing.JTextField userAgentField;
    // End of variables declaration//GEN-END:variables
}

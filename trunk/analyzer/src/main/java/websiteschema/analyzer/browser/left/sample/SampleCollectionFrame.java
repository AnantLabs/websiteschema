/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SampleCollectionFrame.java
 *
 * Created on Oct 6, 2011, 9:51:25 PM
 */
package websiteschema.analyzer.browser.left.sample;

import java.util.Date;
import java.util.List;
import websiteschema.cluster.DocumentConvertor;
import websiteschema.analyzer.context.BrowserContext;
import websiteschema.model.domain.Cipher;
import websiteschema.model.domain.Websiteschema;
import websiteschema.model.domain.cluster.Sample;
import websiteschema.persistence.Mapper;
import websiteschema.persistence.hbase.SampleMapper;
import websiteschema.persistence.rdbms.CipherMapper;
import websiteschema.utils.DateUtil;

/**
 *
 * @author ray
 */
public class SampleCollectionFrame extends javax.swing.JFrame {

    String siteId;
    boolean start = false;
    int count = 0;
    DocumentConvertor docConvertor = new DocumentConvertor();
    CipherMapper cipherMapper = null;

    /** Creates new form SampleCollectionFrame */
    public SampleCollectionFrame() {
        initComponents();

        int screenWidth = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        int sizeWidth = this.getWidth();
        int sizeHeight = this.getHeight();
        this.setLocation((screenWidth - sizeWidth) / 2, (screenHeight - sizeHeight) / 2);
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
        this.setTitle("收集样本 - " + siteId);
    }

    public String getSiteId() {
        return siteId;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        crawlerComboBox = new javax.swing.JComboBox();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        crawlSampleTypeCheckBox = new javax.swing.JCheckBox();
        cookieField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("已采集 :");

        countLabel.setText("0");

        statusLabel.setText("url : ");

        crawlerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "HtmlUnit", "Firefox" }));

        startButton.setText("开始");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        exitButton.setText("退出");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        crawlSampleTypeCheckBox.setSelected(true);
        crawlSampleTypeCheckBox.setText("仅采集新样本");

        jLabel2.setText("Cookie:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(crawlerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(18, 18, 18)
                        .addComponent(crawlSampleTypeCheckBox))
                    .addComponent(cookieField, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(countLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crawlerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton)
                    .addComponent(exitButton)
                    .addComponent(crawlSampleTypeCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cookieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        String clazzName = "websiteschema.crawler.browser.BrowserWebCrawler";
        String selected = (String) this.crawlerComboBox.getSelectedItem();
        if ("HtmlUnit".equalsIgnoreCase(selected)) {
            clazzName = "websiteschema.crawler.htmlunit.HtmlUnitWebCrawler";
        } else if ("Firefox".equalsIgnoreCase(selected)) {
            clazzName = "websiteschema.crawler.browser.BrowserWebCrawler";
        } else {
            clazzName = "websiteschema.crawler.SimpleHttpCrawler";
        }

        cipherMapper = BrowserContext.getSpringContext().getBean("cipherMapper", CipherMapper.class);
        if (null != cipherMapper) {
            Cipher cipher = cipherMapper.getBySiteId(siteId);
            if (null != cipher) {
                setCookie(cipher.getCookie());
            }
        }

        Thread t = new Thread(new SampleCollector(clazzName));
        t.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void setCookie(String cookie) {
        this.cookieField.setText(cookie);
    }

    private String getCookie() {
        return this.cookieField.getText();
    }

    private boolean onlyCrawlNewSample() {
        return crawlSampleTypeCheckBox.isSelected();
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_exitButtonActionPerformed

    private SampleCollectionFrame getInstance() {
        return this;
    }

    public boolean isRunning() {
        return start;
    }

    public void count() {
        count++;
        this.countLabel.setText(String.valueOf(count));
    }

    public void exit() {
        this.dispose();
        start = false;
        System.gc();
    }

    class SampleCollector implements Runnable {

        String crawlerClazzName;

        SampleCollector(String clazzName) {
            crawlerClazzName = clazzName;
        }

        @Override
        public void run() {
            final Mapper<Sample> mapper = BrowserContext.getSpringContext().getBean("sampleMapper", Mapper.class);
            final Mapper<Websiteschema> wMapper = BrowserContext.getSpringContext().getBean("websiteschemaMapper", Mapper.class);
            final Websiteschema w = wMapper.get(getSiteId());
            final SampleCrawler sc = new SampleCrawler();
            sc.setCrawlerClazzName(crawlerClazzName);
            sc.setXPathAttributes(w.getXpathAttr());
            sc.setCookie(getCookie());
            start = true;
            String now = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm");
            String end = getSiteId() + "+" + now;
            List<Sample> samples = mapper.getList(getSiteId(), end);
            int count = 0;
            for (Sample sample : samples) {
                if (isRunning()) {
                    count();
                    String url = sample.getUrl();
                    getInstance().statusLabel.setText(url);
//                    Date lastUpdateTime = sample.getLastUpdateTime();
//                    long interval = null != lastUpdateTime ? System.currentTimeMillis() - lastUpdateTime.getTime() : 0;
                    if (onlyCrawlNewSample()) {
                        if (sample.getHttpStatus() == 0) {
                            sc.fetch(sample);
                            //释放一下内存
                            count++;
                            count = count % 5;
                            if (count == 5) {
                                System.gc();
                            }
                        }
                    } else {
//                        if (sample.getHttpStatus() != 200 || interval > 86400000)
                        {
                            sc.fetch(sample);
                            //释放一下内存
                            count++;
                            count = count % 5;
                            if (count == 5) {
                                System.gc();
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            exit();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cookieField;
    private javax.swing.JLabel countLabel;
    private javax.swing.JCheckBox crawlSampleTypeCheckBox;
    private javax.swing.JComboBox crawlerComboBox;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

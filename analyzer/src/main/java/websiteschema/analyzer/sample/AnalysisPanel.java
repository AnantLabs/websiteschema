/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AnalysisPanel.java
 *
 * Created on Sep 13, 2011, 3:09:14 PM
 */
package websiteschema.analyzer.sample;

import websiteschema.analyzer.sample.SampleCollectionFrame;
import websiteschema.analyzer.sample.SampleFrame;
import com.webrenderer.swing.IMozillaBrowserCanvas;
import com.webrenderer.swing.dom.IElement;
import com.webrenderer.swing.dom.IElementCollection;
import java.net.URI;
import java.util.Date;
import websiteschema.analyzer.browser.SimpleBrowser;
import websiteschema.context.BrowserContext;
import websiteschema.element.XPathAttributes;
import websiteschema.model.domain.Site;
import websiteschema.model.domain.Websiteschema;
import websiteschema.model.domain.cluster.Sample;
import websiteschema.model.domain.cralwer.CrawlerSettings;
import websiteschema.persistence.hbase.SampleMapper;
import websiteschema.persistence.hbase.WebsiteschemaMapper;
import websiteschema.utils.UrlLinkUtil;

/**
 *
 * @author ray
 */
public class AnalysisPanel extends javax.swing.JPanel {

    BrowserContext context;
    SimpleBrowser simpleBrowser = null;
    SampleFrame sf = new SampleFrame();;

    /** Creates new form AnalysisPanel */
    public AnalysisPanel(BrowserContext context, SimpleBrowser simpleBrowser) {
        initComponents();
        this.context = context;
        this.simpleBrowser = simpleBrowser;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sampleDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        siteIdField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mustHaveField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dontHaveField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pageTypeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        encodingField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        depthField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        minDateField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maxDateField = new javax.swing.JTextField();
        saveSettingsButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        viewCategoryButton = new javax.swing.JButton();
        collectSampleButton = new javax.swing.JButton();
        addLinksButton = new javax.swing.JButton();
        viewSampleButton = new javax.swing.JButton();
        trainButton = new javax.swing.JButton();

        javax.swing.GroupLayout sampleDialogLayout = new javax.swing.GroupLayout(sampleDialog.getContentPane());
        sampleDialog.getContentPane().setLayout(sampleDialogLayout);
        sampleDialogLayout.setHorizontalGroup(
            sampleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        sampleDialogLayout.setVerticalGroup(
            sampleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(185, 32767));

        jLabel1.setText("网站ID : ");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("必须包含 :");

        jLabel3.setText("不能包含 :");

        jLabel4.setText("页面类型 :");

        jLabel5.setText("页面编码 :");

        encodingField.setText("UTF-8");

        jLabel6.setText("采集深度 :");

        depthField.setText("0");

        jLabel7.setText("页面创建时间大于 :");

        minDateField.setText("-30");

        jLabel8.setText("页面创建时间小于 :");

        maxDateField.setText("3");

        saveSettingsButton.setText("保存");
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mustHaveField, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dontHaveField, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageTypeField, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encodingField, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depthField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(saveSettingsButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mustHaveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dontHaveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pageTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(encodingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(depthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(minDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(maxDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveSettingsButton)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        viewCategoryButton.setText("查看分类");
        viewCategoryButton.setToolTipText("查看网站页面的分类");
        viewCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCategoryButtonActionPerformed(evt);
            }
        });

        collectSampleButton.setText("收集数据");
        collectSampleButton.setToolTipText("收集样本数据");
        collectSampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectSampleButtonActionPerformed(evt);
            }
        });

        addLinksButton.setText("自动添加样本");
        addLinksButton.setToolTipText("将页面上的所有链接添加为样本");
        addLinksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLinksButtonActionPerformed(evt);
            }
        });

        viewSampleButton.setText("查看样本");
        viewSampleButton.setToolTipText("查看并添加样本");
        viewSampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSampleButtonActionPerformed(evt);
            }
        });

        trainButton.setText("开始训练");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(trainButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewCategoryButton))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(viewSampleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(collectSampleButton))
            .addComponent(addLinksButton)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewSampleButton)
                    .addComponent(collectSampleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addLinksButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trainButton)
                    .addComponent(viewCategoryButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 184, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(siteIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siteIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCategoryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewCategoryButtonActionPerformed

    private void addLinksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLinksButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("addLinksButtonActionPerformed");
        IMozillaBrowserCanvas browser = context.getBrowser();
        IElementCollection links = browser.getDocument().getLinks();
        String pageUrl = context.getReference();
        String siteId = getSiteId();
        if (null != links && null != siteId && !"".equals(siteId)) {
            for (int i = 0; i < links.length(); i++) {
                IElement ele = links.item(i);
                String href = ele.getAttribute("href", 0);
                URI uri = UrlLinkUtil.getInstance().getURL(pageUrl, href);
                if ("http".equals(uri.getScheme())) {
                    context.getConsole().log("add sample: " + uri.getScheme() + ":" + uri.getSchemeSpecificPart());
                    addSampleUrl(uri);
                }
            }
            context.getMsgDialog().msg("添加链接完毕！");
        } else {
            context.getMsgDialog().msg("无法获取链接或者siteId是空或无效！");
        }
    }//GEN-LAST:event_addLinksButtonActionPerformed

    private void saveSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsButtonActionPerformed
        // TODO add your handling code here:
        WebsiteschemaMapper mapper = BrowserContext.getSpringContext().getBean("websiteschemaMapper", WebsiteschemaMapper.class);
        Websiteschema websiteschema = mapper.get(getSiteId());
        CrawlerSettings settings = getCrawlerSettings();
        XPathAttributes attr = this.simpleBrowser.getXPathAttr();
        if (null != settings && null != websiteschema) {
            websiteschema.setCrawlerSettings(settings);
            websiteschema.setXpathAttr(attr);
            websiteschema.setLastUpdateTime(new Date());
            mapper.put(websiteschema);
        }
        context.getMsgDialog().msg("Crawler设置保存成功！");
    }//GEN-LAST:event_saveSettingsButtonActionPerformed

    private void collectSampleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectSampleButtonActionPerformed
        // TODO add your handling code here:
        SampleCollectionFrame ssf = new SampleCollectionFrame();
        ssf.setSiteId(getSiteId());
        ssf.setVisible(true);
    }//GEN-LAST:event_collectSampleButtonActionPerformed

    private void viewSampleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSampleButtonActionPerformed
        // TODO add your handling code here:
        sf.setSiteId(getSiteId());
        sf.setVisible(true);
        sf.loadData();
    }//GEN-LAST:event_viewSampleButtonActionPerformed

    private void addSampleUrl(URI uri) {
//        XPathAttributes attr = this.simpleBorwser.getXPathAttr();
//        this.docConvertor.setXpathAttr(attr);
        String url = uri.getScheme() + ":" + uri.getSchemeSpecificPart();
        CrawlerSettings settings = getCrawlerSettings();
        String[] mustHave = settings.getMustHave();
        String[] dontHave = settings.getDontHave();
        boolean legalUrl = UrlLinkUtil.getInstance().match(url, mustHave, dontHave);
        if (legalUrl) {
            SampleMapper mapper = BrowserContext.getSpringContext().getBean("sampleMapper", SampleMapper.class);
            Sample sample = new Sample();
            String rowKey = UrlLinkUtil.getInstance().convertUriToRowKey(uri, getSiteId());
            sample.setRowKey(rowKey);
            sample.setUrl(url);
            sample.setSiteId(getSiteId());
            sample.setCreateTime(new Date());
            mapper.put(sample);
        }
    }

    public void setSiteId(String siteId) {
        this.siteIdField.setText(siteId);
        WebsiteschemaMapper mapper = BrowserContext.getSpringContext().getBean("websiteschemaMapper", WebsiteschemaMapper.class);
        Websiteschema websiteschema = mapper.get(siteId);
        if (null != websiteschema) {
            CrawlerSettings settings = websiteschema.getCrawlerSettings();
            setCrawlerSettings(settings);
        }
    }

    public String getSiteId() {
        return this.siteIdField.getText().trim();
    }

    public void startAnalysis(Site site) {
    }

    public CrawlerSettings getCrawlerSettings() {
        CrawlerSettings settings = new CrawlerSettings();

        settings.setMustHave(this.mustHaveField.getText().trim().split(","));
        settings.setDontHave(this.dontHaveField.getText().trim().split(","));
        settings.setAcceptedType(this.pageTypeField.getText().trim().split(","));
        settings.setEncoding(this.encodingField.getText().trim());
        settings.setMaxDepth(Integer.valueOf(this.depthField.getText().trim()));
        settings.setMinDate(Integer.valueOf(this.minDateField.getText().trim()));
        settings.setMaxDate(Integer.valueOf(this.maxDateField.getText().trim()));

        return settings;
    }

    public void setCrawlerSettings(CrawlerSettings settings) {
        if (null != settings) {
            this.mustHaveField.setText(arrayToString(settings.getMustHave()));
            this.dontHaveField.setText(arrayToString(settings.getDontHave()));
            this.pageTypeField.setText(arrayToString(settings.getAcceptedType()));
            this.encodingField.setText(settings.getEncoding());
            this.depthField.setText(String.valueOf(settings.getMaxDepth()));
            this.minDateField.setText(String.valueOf(settings.getMinDate()));
            this.maxDateField.setText(String.valueOf(settings.getMaxDate()));
        }
    }

    private String arrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();

        if (null != array) {
            for (String str : array) {
                sb.append(str).append(",");
            }

        }
        String ret = sb.toString();
        if (ret.endsWith(",")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLinksButton;
    private javax.swing.JButton collectSampleButton;
    private javax.swing.JTextField depthField;
    private javax.swing.JTextField dontHaveField;
    private javax.swing.JTextField encodingField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField maxDateField;
    private javax.swing.JTextField minDateField;
    private javax.swing.JTextField mustHaveField;
    private javax.swing.JTextField pageTypeField;
    private javax.swing.JDialog sampleDialog;
    private javax.swing.JButton saveSettingsButton;
    private javax.swing.JTextField siteIdField;
    private javax.swing.JButton trainButton;
    private javax.swing.JButton viewCategoryButton;
    private javax.swing.JButton viewSampleButton;
    // End of variables declaration//GEN-END:variables
}

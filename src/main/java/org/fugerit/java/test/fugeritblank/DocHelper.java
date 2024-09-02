package org.fugerit.java.test.fugeritblank;

import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfig;
import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfigFacade;

/**
 * DocHelper, version : auto generated on 2024-09-02 23:04:26.538
 */
public class DocHelper {

     private FreemarkerDocProcessConfig docProcessConfig = FreemarkerDocProcessConfigFacade.loadConfigSafe( "cl://fugerit-blank/fm-doc-process-config.xml" );

     public FreemarkerDocProcessConfig getDocProcessConfig() { return this.docProcessConfig; }

}

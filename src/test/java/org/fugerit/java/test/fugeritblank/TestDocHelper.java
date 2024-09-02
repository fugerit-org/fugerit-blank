package org.fugerit.java.test.fugeritblank;

import lombok.extern.slf4j.Slf4j;
import org.fugerit.java.core.function.SafeFunction;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Slf4j
class TestDocHelper {

    @Test
    void test() {
        Assertions.assertTrue( SafeFunction.get( () -> {
            String type = DocConfig.TYPE_XLSX;
            File outputFile = new File( "target/test."+type );
            try (FileOutputStream os = new FileOutputStream( outputFile ) ) {
                // creates the doc helper
                DocHelper docHelper = new DocHelper();
                // create custom data for the fremarker template 'document.ftl'
                List<DocHelperExample.People> listPeople = Arrays.asList( new DocHelperExample.People( "Luthien", "Tinuviel", "Queen" ), new DocHelperExample.People( "Thorin", "Oakshield", "King" ) );
                // handler id
                String handlerId = DocConfig.TYPE_MD;
                // output generation
                docHelper.getDocProcessConfig().fullProcess( "document", DocProcessContext.newContext( "listPeople", listPeople ), handlerId, os );
                log.info( "document created : {}", outputFile.getCanonicalPath() );
                return outputFile.exists();
            }
        }) );
    }

}

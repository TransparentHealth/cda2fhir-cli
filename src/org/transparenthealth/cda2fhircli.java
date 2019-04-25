import tr.com.srdc.cda2fhir.transform.CCDTransformerImpl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;

import org.hl7.fhir.dstu3.model.Practitioner;
import org.openhealthtools.mdht.uml.cda.consol.ConsolPackage;
import org.openhealthtools.mdht.uml.cda.consol.ContinuityOfCareDocument;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.cda2fhir.conf.Config;
// import tr.com.srdc.cda2fhir.testutil.BundleUtil;
import tr.com.srdc.cda2fhir.transform.CCDTransformerImpl;
import tr.com.srdc.cda2fhir.transform.ICDATransformer;
import tr.com.srdc.cda2fhir.transform.util.IdentifierMapFactory;
import tr.com.srdc.cda2fhir.util.FHIRUtil;
import tr.com.srdc.cda2fhir.util.IdGeneratorEnum;
import org.hl7.fhir.dstu3.model.Bundle;


class CommandLine {
    public static void main(String... args) {
        // CDAUtil.loadPackages();

        // IResourceTransformer resTransformer = new ResourceTransformerImpl();
        System.out.println("Hello World.");
        CDAUtil.loadPackages();

        for(int i=0;i< args.length;i++)
            {
            System.out.println(args[i]);
            try{
               FileInputStream fis = new FileInputStream(args[i]);
               ClinicalDocument cda = CDAUtil.loadAs(fis);
               // ContinuityOfCareDocument ccd = (ContinuityOfCareDocument) CDAUtil.loadAs(fis, ConsolPackage.eINSTANCE.getContinuityOfCareDocument());

               CCDTransformerImpl ccdTransformer = new CCDTransformerImpl(IdGeneratorEnum.COUNTER);
               Bundle bundle = ccdTransformer.transformDocument(cda);
               //Bundle bundle = ccdTransformer.transformDocument(args[i]);
               FHIRUtil.printJSON(bundle, "out.json");
               }
           catch (FileNotFoundException e)
              {
              System.out.println("File not found.");
              }

            catch (Exception e)
            {
                System.out.println(e);
            }

            }
       
    }
}

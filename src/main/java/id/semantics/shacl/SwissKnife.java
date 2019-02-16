package id.semantics.shacl;

import org.apache.commons.io.IOUtils;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.*;
import java.nio.charset.Charset;

public class SwissKnife {

    public static File getFileFromResource(String fileName) {
        return new File(SwissKnife.class.getClassLoader().getResource(fileName).getFile());
    }

    public static Model initAndLoadModelFromInput(String dataModelFile, Lang lang) throws FileNotFoundException {
        InputStream dataModelIS = new FileInputStream(dataModelFile);
        Model dataModel = ModelFactory.createDefaultModel();
        RDFDataMgr.read(dataModel, dataModelIS, lang);
        return dataModel;
    }

    public static Model initAndLoadModelFromResource(String dataModelFile, Lang lang) {
        InputStream dataModelIS = SwissKnife.class.getClassLoader().getResourceAsStream(dataModelFile);
        Model dataModel = ModelFactory.createDefaultModel();
        RDFDataMgr.read(dataModel, dataModelIS, lang);
        return dataModel;
    }

    public static Dataset initAndLoadDatasetFromResource(String dataModelFile, Lang lang) {
        InputStream dataModelIS = SwissKnife.class.getClassLoader().getResourceAsStream(dataModelFile);
        Dataset dataset = DatasetFactory.create();
        RDFDataMgr.read(dataset, dataModelIS, lang);
        return dataset;
    }

    public static ParameterizedSparqlString initAndLoadQueryFromResource(String queryFile) throws IOException {
        InputStream dataModelIS = SwissKnife.class.getClassLoader().getResourceAsStream(queryFile);
        String string = IOUtils.toString(dataModelIS, Charset.forName("UTF-8"));
        ParameterizedSparqlString query = new ParameterizedSparqlString(string);
        return query;
    }
}

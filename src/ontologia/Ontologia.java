/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontologia;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;


/**
 *
 * @author elena
 */

public class Ontologia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String NS = "http://www.vortic3.com/IFOPT/";
        
        // Create Ontology
        final OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
        
        // Specify Access Metro prefix 
        ontologia.setNsPrefix("AccM", NS);
        
        // Create Ontology Classes
        final OntClass stopPlaceEquipment = ontologia.createClass(NS+"StopPlaceEquipment");
        final OntClass passengerInfoEquipment = ontologia.createClass(NS+"PassengerInfoEquipment");
        final OntClass accessEquipment = ontologia.createClass(NS+"AccessEquipment");
        final OntClass sign = ontologia.createClass(NS+"Sign");
        
        // Add Properties (creo que esto es repetir las cosas pero ahí lo dejo hasta que esté segura)
        
        stopPlaceEquipment.addSubClass(stopPlaceEquipment);
        stopPlaceEquipment.addSubClass(passengerInfoEquipment);
        stopPlaceEquipment.addSubClass(sign);
        
        stopPlaceEquipment.addRDFType(passengerInfoEquipment);
        stopPlaceEquipment.addRDFType(accessEquipment);
        stopPlaceEquipment.addRDFType(sign);
        
        ontologia.write(System.out);
        
    }
    
}

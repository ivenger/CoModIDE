package com.karlhammar.xdp.views;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.karlhammar.xdp.sdont.model.SDGraph;
import com.karlhammar.xdp.sdont.parsing.OntologyParser;
import com.karlhammar.xdp.sdont.ui.SDontViewFrame;
import com.karlhammar.xdp.sdont.viz.SDMaker;

public class RendererView extends AbstractOWLViewComponent
{
    /* Book keeping */
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RendererView.class);

    /* ui objects */
    private JLabel tempRight;

    @Override
    protected void initialiseOWLView() throws Exception
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // Renderer Frame
        // this is probably not going to work at the moment, as there is no ontology loaded at initialization
        // we will have to put some sort of update method written. 
        // I think there is something in the OPLa Plugin and OWLax that can help with this.
        OntologyParser ontologyParser = new OntologyParser(getOWLModelManager());
        SDGraph graph = ontologyParser.parseOntology();
        SDMaker maker = new SDMaker(graph);
        SDontViewFrame sdont = maker.visualize();
        add(sdont);
        
        // Create Horizontal glue
        add(Box.createHorizontalGlue());
        
        // Palette Frame
        tempRight = new JLabel("I am the Schema Diagram Rendering View Right.");
        add(tempRight);

        // Finish and Log
        log.info("CoMoDIDE View initialized");
    }

    @Override
    protected void disposeOWLView()
    {
        log.info("Rendering View disposed");
    }
}

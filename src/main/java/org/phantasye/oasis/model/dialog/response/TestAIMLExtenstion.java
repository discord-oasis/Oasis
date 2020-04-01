package org.phantasye.oasis.model.dialog.response;

import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.AIMLProcessorExtension;
import org.alicebot.ab.ParseState;
import org.alicebot.ab.Utilities;
import org.phantasye.oasis.Oasis;
import org.w3c.dom.Node;

import java.util.Set;

public class TestAIMLExtenstion implements AIMLProcessorExtension
{
    public Set<String> extensionTagNames = Utilities.stringSet("contactid","multipleids","displayname","dialnumber","emailaddress","contactbirthday","addinfo");
    public Set <String> extensionTagSet() {
        return extensionTagNames;
    }

    public String recursEval(Node node, ParseState ps) {
        try {
            String nodeName = node.getNodeName();
            Oasis.GLOBAL_LOGGER.info("NODE NAME: " + nodeName);
            if(nodeName.equals("contactid")) {
                return contactId(node,ps);
            }
             return (AIMLProcessor.genericXML(node, ps));
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    private String contactId(Node node, ParseState ps) {
        String displayName = AIMLProcessor.evalTagContent(node, ps, null);
        Oasis.GLOBAL_LOGGER.info("WELCOME CHANNEL SET TO: " + displayName);
        return "TESTING";
    }
}

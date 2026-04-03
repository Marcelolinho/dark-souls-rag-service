package org.mpp.ai;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.Result;


public class GeminiRagService {

    

    @Tool(name = "This is a tool designed to find data about a dark souls topic")
    public Result<String> retrieveDarkSoulsInformation() {


        return null;
    }
}

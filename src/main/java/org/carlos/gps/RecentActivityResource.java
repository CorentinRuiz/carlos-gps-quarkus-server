package org.carlos.gps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/activity")
public class RecentActivityResource {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/recentSearch.json";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/recentSearch")
    public List<Search> getRecentActivity() throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return Arrays.asList(mapper.readValue(new File(FILE_PATH),Search[].class));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/recentSearch")
    public Response sendRecentActivity(Search search) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<Search> recentListSearch = new ArrayList<>(Arrays.asList(mapper.readValue(new File(FILE_PATH),Search[].class)));

        if (recentListSearch.isEmpty()) {
            recentListSearch = new ArrayList<>();
        }

        recentListSearch.add(search);
        mapper.writeValue(new File(FILE_PATH),recentListSearch);

        return Response.ok(recentListSearch).build();
    }
}
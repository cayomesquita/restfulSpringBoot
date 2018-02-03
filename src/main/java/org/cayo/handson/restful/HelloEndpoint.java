package org.cayo.handson.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class HelloEndpoint {
//    @Inject
//    NamedParameterJdbcTemplate jdbcTemplate;

    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello World!";
    }

//    @Data
//    static class Result {
//        private final int left;
//        private final int right;
//        private final long answer;
//    }

    // SQL sample
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("calc")
//    public Result calc(@QueryParam("left") int left, @QueryParam("right") int right) {
//        MapSqlParameterSource source = new MapSqlParameterSource()
//                .addValue("left", left)
//                .addValue("right", right);
//        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
//                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
//    }
}

package pro.progr.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class JdbcGreetingRepository implements GreetingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGreetingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Greeting save(String content) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO greetings(content) VALUES (?)", new String[] {"id"});
            ps.setString(1, content);
            return ps;
        }, keyHolder);
        return new Greeting(keyHolder.getKey().longValue(), content);
    }

    @Override
    public Greeting findById(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, content FROM greetings WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Greeting(rs.getLong("id"), rs.getString("content"))
        );
    }
}
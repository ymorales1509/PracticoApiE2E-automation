package examples.users;

import com.intuit.karate.junit5.Karate;

class PetstoreUserTest {

    static {
        System.setProperty("karate.output.dir", "Report");
    }

    @Karate.Test
    Karate ejecutarFeature() {
        return Karate.run("petstore-user").relativeTo(getClass());
    }
}

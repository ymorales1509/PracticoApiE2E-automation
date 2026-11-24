package examples.users;

import com.intuit.karate.junit5.Karate;

class PetstoreUserTest {

    @Karate.Test
    Karate ejecutarFeature() {
        return Karate.run("petstore-user").relativeTo(getClass());
    }
}

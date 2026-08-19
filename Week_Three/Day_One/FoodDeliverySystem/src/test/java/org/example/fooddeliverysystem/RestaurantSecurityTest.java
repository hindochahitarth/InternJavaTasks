package org.example.fooddeliverysystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestaurantSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void customerCannotAddRestaurant() throws Exception {

        mockMvc.perform(
                        post("/api/restaurants/add-restaurant")
                                .with(
                                        user("customer")
                                                .roles("CUSTOMER")
                                )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                            {
                                "name": "Test Restaurant"
                            }
                        """)
                )
                .andExpect(status().isForbidden());
    }
    @Test
    void restaurantOwnerCanAddRestaurant() throws Exception {

        mockMvc.perform(
                        post("/api/restaurants/add-restaurant")
                                .with(user("restaurantOwner")
                                        .roles("RESTAURANT_OWNER"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                        {
                            "name": "Food Palace 7",
                            "description": "Delicious Indian and Italian food",
                            "address": "Main Road",
                            "city": "Vadodara",
                            "phone": "9876543210",
                            "email": "foooddpalace7@gmail.com",
                            "ownerId": 2,
                            "cuisineTypeIds": [1, 2]
                        }
                    """)
                )
                .andExpect(status().isCreated());
    }
}
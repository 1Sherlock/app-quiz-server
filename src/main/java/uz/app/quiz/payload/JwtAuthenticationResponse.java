package uz.app.quiz.payload;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private ResUser user;

    public JwtAuthenticationResponse(String accessToken, ResUser user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}

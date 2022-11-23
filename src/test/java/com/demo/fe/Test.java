package com.demo.fe;

import java.util.Base64;

public class Test {

    public static void main(String[] args) {

        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJfd2lOelZodzNKOU4xdzd2Q2hKNXJKbnZoRWJxTWpOdEVvRm1BRElST2IwIn0.eyJleHAiOjE2Njg2NTQwNzYsImlhdCI6MTY2ODY1Mzc3NiwianRpIjoiYTcwYzk2MDAtYWVhMy00YTMyLWFiZTEtOTI0MTY0ZjJhOGUxIiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo4MDgwL2F1dGgvcmVhbG1zL2RlbW8iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiY2RhZTNkYWEtNmFlMC00ZWZhLTk1YzgtMWM1Zjg3YzZkNDI0IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZGVtby1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiZDFjMTVjOTItNDE4Zi00NDlkLWIxMWUtOTIwOTNhMjlkZGQzIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1kZW1vIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiZGVtby1jbGllbnQiOnsicm9sZXMiOlsiUk9MRV9VU0VSIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiJkMWMxNWM5Mi00MThmLTQ0OWQtYjExZS05MjA5M2EyOWRkZDMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJ0ZXN0IHVzZXIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ0ZXN0X3VzZXJfMDAxIiwiZ2l2ZW5fbmFtZSI6InRlc3QiLCJmYW1pbHlfbmFtZSI6InVzZXIiLCJlbWFpbCI6InRlc3RfdXNlcl8wMDFAdGVzdC5jb20ifQ.FjdI_eb-Epw_lPoX9fTrn8fCnAqhz45le3QA6-YKpMhCk1AedF_GEaBbRcLOYyTgyOiv_kmdGsn1Bt0F3EbkySNdWk_dP1tzfwYkz8DkQ-oje4ifFlHu7-xnrNn_WixMybYKYRSQwQgFR69jvm1-klh1CM27ab606q_YeiDvZGaBk5DmRJGEAPBSjv7GlXIIFw8RpBfu-RKLAWGfsvSu5-MSY-kf73V22N4CvQOgIwQ-P-KkQxA2TUN_a-CuIR5KqIKS1YYrHucLhRkqsMC40-2KxAu0GK72YfFXt3A2N6Nu-KsbmrfZngiR89DPFk_Q8cT2JOsrBuFiEj1tGmbscw";
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        System.out.println(header);
        System.out.println(payload);

    }
}

# Currency_Converter
This is a Spring Boot application that provides real-time currency conversion using a public exchange rates API.

# Features
1. Fetch real-time exchange rates from a public API.
2. Convert an amount from one currency to another.
3. Handle API failures and invalid currency codes.
4. Basic unit tests for service layer.

# Prerequisites
1. Java 17+ version required.
2. Spring Boot is required.
3. Generate a valid API key from ExchangeRates API (https://exchangeratesapi.io/) from this website.
4. Postman API is required for the proper working.

# Setup
1. Clone the Repository
   git clone https://github.com/godwinjohnson2001/Currency_Converter.git
   
   cd Currency-Converter
2. Update API Key Open src/main/resources/application.properties and replace YOUR_API_KEY with a valid key:
   exchange.api.url=https://api.exchangeratesapi.io/v1/latest?access_key=YOUR_API_KEY

3. Run the project from your IDE. Here VS Code is used to build the project
4. Verify the Application Open your browser or use POSTMAN API:
   "http://localhost:8080/api/"

# API Endpoints
1. Get Exchange Rates:
   1.1 open your brower and go to "http://localhost:8080/api/rates"
             OR
   1.2 open postman and set GET http request and pass this endpoint "http://localhost:8080/api/rates"
2. Convert Currency:
   Description: Convert an amount from one currency to another.
   2.1 open your browser and go to "http://localhost:8080/api/convert" . Then enter the currency name and the amount and to which currency. 
             OR
   2.2 open postman then set POST http request and pass this endpoint "http://localhost:8080/api/convert". Then pass the request in JSON format in the body.
    2.2.1 Request Body:
                 {
                    "from": "USD",
                    "to": "EUR",
                    "amount": 100
                  }
    2.2.2 Example Response:
                {
                    "from": "USD",
                     "to": "EUR",
                    "amount": 100,
                    "convertedAmount": 94.5
                }
# Error Handling
1. 400 Bad Request: Invalid currency codes.
2. 401 Unauthorized: API key missing or invalid.
3. 500 Internal Server Error: External API failure.

# Troubleshooting
1. API Key Error (401 Unauthorized):
       Ensure you have a valid API key in application.properties.
2. Port Conflict:
       Change port in application.properties:
            server.port=8081
   

   

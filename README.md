# LoyaltyFirst

LoyaltyFirst Inc. is a music store that needs to develop a customer loyalty program supported by an Oracle database backend. The customer loyalty program also known as a "frequent customer" program identifies LoyaltyFirst customers as valued members through a card that accumulates loyalty points whenever they buy items from the LoyaltyFirst store. 

## Installation

Import the below package:

```bash
import com.android.volley.toolbox.Volley;
```

## APPLICATION INTERFACE
Login Page: 
Upon accessing the login page, users are prompted to enter their username and password. If incorrect credentials are provided, a notification toast will display indicating an incorrect password.
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/da103a6d-24cf-471e-8c11-f46bee8fb3da)

Main Page: 
The main page showcases the user's name, profile image, and current reward points. It features five buttons, each serving a specific function.
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/168612e9-428e-49d8-b9d3-cdecf337ba43)

First Button - ALL TXNS
Clicking this button reveals transaction details, including Transaction Reference Number, Transaction Date, Transaction Points, and Total Points.
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/ccbdb679-49cd-4e6c-a1e9-42f9241d98fb)

Second Button - TXN DETAILS
This button provides more in-depth information about a selected transaction. A spinner allows users to choose a specific transaction, displaying the transaction date, points, purchased products, quantities, and points per product.
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/87f91ef3-3c0f-4423-82b6-342d5ba260d0)

Third Button - REDMPTN DETAILS
Clicking this button reveals prize details that users can obtain using their accumulated points. The spinner contains Prize IDs, and upon selection, information such as Prize Description, Points Required, Redemption Date, and Exchange Center is displayed. 
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/b1df30a5-457b-4e34-b67e-17288623dc92)

Fourth Button - ADD % TO FAMILY
Upon clicking this button, users can select a transaction to transfer points to a family member. The top section includes a spinner with multiple transactions, displaying transaction points, family ID, and family percentage. Clicking the "ADD FAMILY POINTS" button calculates the points to be transferred, distributing them among the associated family members.
![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/242c539f-7a82-4f36-8b7e-a89c975e8096)

## License

[MIT](https://choosealicense.com/licenses/mit/)

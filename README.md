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

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/6f52d36f-e554-460b-8672-c0f832bcaee2)


Main Page: 

The main page showcases the user's name, profile image, and current reward points. It features five buttons, each serving a specific function.

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/3ad9a369-1d38-411e-9484-c2480c349df5)


First Button - ALL TXNS

Clicking this button reveals transaction details, including Transaction Reference Number, Transaction Date, Transaction Points, and Total Points.

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/a70615d6-ddbd-49da-9373-e1e8e0defd2e)

Second Button - TXN DETAILS

This button provides more in-depth information about a selected transaction. A spinner allows users to choose a specific transaction, displaying the transaction date, points, purchased products, quantities, and points per product.

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/6611c668-ad37-40b1-a105-e5da7945f715)

Third Button - REDMPTN DETAILS

Clicking this button reveals prize details that users can obtain using their accumulated points. The spinner contains Prize IDs, and upon selection, information such as Prize Description, Points Required, Redemption Date, and Exchange Center is displayed.

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/541cb4f3-be21-4105-a9ae-cea761276300)

Fourth Button - ADD % TO FAMILY

Upon clicking this button, users can select a transaction to transfer points to a family member. The top section includes a spinner with multiple transactions, displaying transaction points, family ID, and family percentage. Clicking the "ADD FAMILY POINTS" button calculates the points to be transferred, distributing them among the associated family members.

![image](https://github.com/rahulkumarmmmut/LoyaltyFirst1/assets/87722928/1661e414-eecc-45f6-9e85-b63d81cf6729)


## License

[MIT](https://choosealicense.com/licenses/mit/)

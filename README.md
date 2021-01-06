You are asked to develop a system for a bank. 
Requirements:
o	The customer:
▪	can be a Canadian/non-Canadian resident, 
▪	can apply for a credit line because she has a good credit score/cannot apply for a credit line, 
▪	can get some special promotion since she spent $5000 last month/cannot get the promo
▪	can have several bank products (credit card, credit line, mortgage, business account, investment account, retirement account etc.)
o	System stores information about customer family members who are not customers of our bank (if she provides us with this data)
o	All the business logic should be moved to separate classes. Ie, logic for CreditCard should be stored in CreditCardService etc. 
o	Methods in Service classes must be covered with unit-tests. All the possible scenarios for each method must be covered in separate tests, as opposed to having them in one place (ie, the customer spent <$5k/month; customer spent >$5k/month, the customer didn’t spend anything, customer object is null etc)
o	Custom exception(s) might be created to adjust the flow of the program if required


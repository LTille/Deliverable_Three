IS2545 - DELIVERABLE 2: Selenium Testing

This is a project took me lots of time exploring, especially in testing the shopping cart function where involves several interaction using JavaScript. 
When I tried to test if I can add one product successfully into the cart, I can observe from the browser that the product number in the shopping cart has increased by 1. However, the test to justify if the count is really 1 failed.  I debugged and confirmed that the “Continue to Shopping" button has been clicked, and product has been added successfully, while the count I retrieved from the webpage always remains to be 0. I struggled so long and finally the test got passed once I refreshed the webpage. 

Another problem is also related to the JavaScript-controlled popup window after clicking “Add to Cart” button, but this time, instead of clicking “Continue to Shopping”, I clicked “Go to Checkout”.  The website cannot been redirected to the checkout page because of the insufficient waiting time, which I realized after several trail. In the end, I redirect to the checkout web address manually.

The third problem occurred when I was trying to test the product quantity update function, which is also resulted from waiting time.  Considering the fact that there is no new element to wait before I can retrieve element after clicking “Update” button, I used the unrecommended waiting scheme, Thread.sleep to make my test pass.  

User Story 1:
    As a user
    I want to log in
    So that I can buy products
    
    Scenario 1:   
      Given a correct username and correct password
      When I try to log in with those credentials
      Then I should see some greeting message
     
    Scenario 2:
      Given a correct username
      When I try to log in with those credentials
      Then I should see error message informing me empty field
     
    Scenario 3:
      Given a incorrect username and incorrect password
      When I try to log in with those credentials
      Then I should see the error credential message

User Story 2:
    As a user
    I want to search for specified products
    So that I can find desired product more quickly
    
    Scenario 1:
       Given a not existed product name
       When I search the product
       Then I should see the "*." message

    Scenario 2:
       Given an existed product name
       When I search the product
       Then I should see a list of products
     
User Story 3:
    As a user
    I want to use shopping cart
    So that I can manipulate products I want to buy
     
    Scenario 1:
       Given an empty cart and iphone 5 product page
       When I try to add an iphone5 into cart
       Then I should see the product number in cart turns into 1
    
    Scenario 2:
       Given 1 iphone5 in the cart
       When I try to update the quantity into 3
       Then I should see the total price triples
       
    Scenario 3:
       Given 1 iphone5 in the cart
       When I try to update the quantity into -1
       Then I should see error message

# tredence

The service consists of 2 main parts:
1. Interface with data team (internal) - Receiving shoppers’ personalized information and product metadata from our data team and storing it in a specified mysql database.
      
       /internal/shopper
       /internal/metadata

2. Interface with eCommerce (external) - Provide fast-reading operation for the shoppers’ personalized information.


       /external/search
      

   

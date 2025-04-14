Feature: Made In China Feature Testing

    Background: PreConditions
    Given the browser is launched and navigates to "https://www.made-in-china.com/"
    And the popup closed
  

  @TestCase02
   Scenario: User Registration and Sign In
    When the user hovers over the Sign In button
    And the user hovers over the Join Free button
    And user clicks on the Join Free button
    And the user switches to the registration window
    And the user hovers over the email input field
    And the user clicks on the email input field
    And the user enters the email "bharani533@gmail.com"
    And the user clicks on the Agree button
    And the user captures a screenshot

  @TestCase01
  Scenario: Search and filter products based on categories and certifications

    Then the "Made in China" logo is displayed on the homepage
    When I identify the search bar element
    And I enter "Electronics" into the search bar
    And I click the search button or press Enter
    Then the search results page title should contain the keyword "Electronics"

    When I wait for the search results to load
    And I click on the "Supplier List" module
    And I identify a filter option "Category"
    And I select the filter value "Consumer Electronics"
    And only products from the "Consumer Electronics" category should be displayed

    When I identify the "Management Certification" section
    And I select "ISO 9000"
    And the "ISO 9000" filter should be displayed under the "Management Certification" section

    When I identify the "Member & Type" section
    And I select the "Diamond Member" checkbox
    And the results should display only "Diamond Member" listings

    When I click on the first displayed company result
    Then I should be redirected to the company's page
    And the page should contain the keyword "Diamond Member"
    And I capture a screenshot of the page
  
   @TestCase03
  Scenario: User submits an inquiry for a product
    When the user identifies the search bar element
    And the user enters "<Product Name>" into the search bar
    And the user clicks the search button or presses Enter
 
    When the user clicks on the first product company
    Then the user validates the product detail page title matches the product name
    And the user identifies the Inquiry or Contact Now button
    When the user clicks the Inquiry or Contact Now button
    Then the user validates the send inquiry form is displayed
    When the user enters "<Invalid Data>" into the content box
 
    And the user inputs a dummy email id "<Email>" into the email address field
    And the user clicks the Send Inquiry or Submit button
    Then the user enters the "<Person Name>" in the name field
    And the user enters the "<Company Name>" in the company name field
    And the user enters the "<Mobile>" in the phone number field and submits the form
    Then the user verifies a successful inquiry submission message is displayed
 
    And the user takes a screenshot for verification
    And attaches the screenshot to the report for reporting purposes
 
    Examples:
    | Product Name    | Invalid Data                                                                                       | Email            | Person Name | Company Name | Mobile    |
    | product's spices | Material: Stainless Steel, Size: 10x10 cm, Application: Industrial machinery, Specifications: Grade 304, thickness 2 mm, Other Requirements: Need a quote for 500 units | abcde@gmail.com | Raja        | LTI          | 9090909090 |

@wiresAndFurnitures
Scenario:  Search Wires And Furnitures
Then user lands on home page
When search for Wires
|Wires|

Then user is taken to "Wires, China Wires, Wires Manufacturers, China Wires catalog" page
When user click on first product link in search results
Then user is taken to "Factory UL83 Electric Power Electrical Cable Thhn Wire 14/12/10AWG Power Aluminum Copper UL Certification Cable - Thhn Wire and Thhn Wire 12" product page
When user returns back to parent window 
And search for Furniture
|Furniture|

Then user is taken to "Furniture, China Furniture, Furniture Manufacturers, China Furniture catalog" page
When user click on "more" link
And navigate to second page of the results
Then user is taken to second page of the results
When user click on site logo
Then user is taken to "Made-in-China.com - Manufacturers, Suppliers & Products in China" page

    @TestCase05
    Scenario: Language Change Verification
    When the user hovers over the Sign In / Join button
    And the user clicks on the Join Free button
    Then the "Register" should be displayed
    When the user clicks on the Sign in now Link 
    Then the user should land on "Sign In | Made-in-China.com" page 
    And user hovers over the language dropdown
    Then the user updates the language selection and verifies the text changes:
      | Language          | 
      | Español           | 
      | Français          | 
      | Deutsch           | 
      | Русский язык      | 
      | 日本語            | 
      | English           |

     @TestCase06
   Scenario: User searches for a product and applies filters
    When the user searches for "LED lights" in the search bar
    Then the search results for "LED light" should be displayed

    When the user clicks the "LED Strip Light" filter

    When the user clicks the "Contact Now" or "Inquire Now" button
    And fills the inquiry form with "I would like to inquire about your services" in Content and "fgfge@gmail.com" in Email Address

    And clicks the "Send Inquiry Now" button
    When the user navigates back to the homepage using the site logo
    When the user hovers over "Lights & Lighting" under the Categories section
    And hovers over "LED Tube" under the "LED Interior Lighting" section
    
    And the keyword "LED Tube" should be present on the product list page

    When the user clicks the "LED Light Tube" filter

    @TestCase07
    Scenario: Navigate through Sections and Return Back
    When the user moves the cursor over the Buyer section
    And the user selects the New User Guide link
    And the user changes to the new window of User Guide
    Then the URL should contain "how-to-source-products-on-made-in-china-com"
    And the user clicks on the Return Back button
    When the user hovers over the Buyer section again
    And the user clicks on the Audited Suppliers Reports link
    And the user switches to the new window of Audited Suppliers
    Then the URL should include "audited-suppliers"
    And the user presses the Return Back button
    When the user navigates to the Buyer section once more
    And the user chooses the Meet Suppliers link
    And the user switches to the new window of Meet Suppliers
    Then the URL should contain "private-sourcing-meetings"
    And the user clicks on the Return Back button or logo page
    And the user captures a screenshot

   @TestCase08
  Scenario: User verifies "Hot Items" section links and redirection

    When the user clicks on links in the "Hot Items" section
    Then the following redirections should occur successfully
      | Title                             | URL Contains                           |
      | Furniture                        | Furniture.html                         | 
      | Apparel & Clothing               | Apparel-Clothing.html                  |
      | Auto Parts & Accessories         | Auto-Parts-Accessories.html            | 
      | Bags, Cases & Luggages           | Bags-Cases-Luggages.html               |
      | Computer Products                | Computer-Products.html                 |                     
      | Consumer Electronics             | Consumer-Electronics.html              |                
      | Electrical Equipment             | Electrical-Equipments.html             |      
      | Electronic Components            | Electronic-Components.html             |          
      | Gifts, Crafts & Collectibles     | Gifts-Crafts-Collectibles.html         | 
      | Building Materials & Supplies    | Building-Materials-Supplies.html       | 
      
    When logs and screenshots are captured
    Then they should verify successful navigation and expected outcomes


  @TestCase09
   Scenario: Verify  Category Page Navigation
   When user click on "Categories" in the side bar
   Then user navigate through categories and verify keywords:
       | Category                                |
       | Manufacturing & Processing Machinery    | 
       | Consumer Electronics                    | 
       | Industrial Equipment & Components       | 
       | Electrical & Electronics                | 
       | Construction & Decoration               | 
       | Light Industry & Daily Use              | 
       | Auto, Motorcycle Parts & Accessories    | 
       | Apparel & Accessories                   | 
       | Lights & Lighting                       |
       | Sporting Goods & Recreation             | 


  @TestCase10
  Scenario: Verify navigation and redirection for Product Directory links using a Data Table
    Given the user hovers over the buyer module
    And the user clicks on "Product Directory" under the search section
    Then the browser navigates to the "Products Directory" page in a new tab

    When the user iterates through the Product Directory links
    | ItemName                          | ExpectedURL                                                                                       | Action                 | Filename                  |
    | Machine Tools                     | /Manufacturing-Processing-Machinery-Catalog/Machine-Tools.html                                   |                        |                           |
    | Engineering & Construction Machinery | /Manufacturing-Processing-Machinery-Catalog/Engineering-Construction-Machinery.html           |                        |                           |
    | Woodworking Machinery             | /Manufacturing-Processing-Machinery-Catalog/Woodworking-Machinery.html                          |                        |                           |
    | Plastic Machinery                 | /Manufacturing-Processing-Machinery-Catalog/Plastic-Machinery.html                              |                        |                           |
    | Metallic Processing Machinery     | /Manufacturing-Processing-Machinery-Catalog/Metallic-Processing-Machinery.html                  |                        |                           |
    | Mould                             | /Manufacturing-Processing-Machinery-Catalog/Mould.html                                           |                        |                           |
    | Laser Equipment                   | /Manufacturing-Processing-Machinery-Catalog/Laser-Equipment.html                                |                        |                           |
    | Casting & Forging                 | /Manufacturing-Processing-Machinery-Catalog/Casting-Forging.html                                | log:click on casting  |                           |
    | Agricultural Machinery            | /Manufacturing-Processing-Machinery-Catalog/Agricultural-Machinery.html                         | screenshot            | agricultural_machinery   |

    Then the browser redirects to the correct page for each link
    And the URL contains the expected value
    And logs and screenshots are handled for specific actions
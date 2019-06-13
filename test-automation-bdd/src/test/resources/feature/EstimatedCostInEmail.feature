Feature: Google cloud calculator

  Background:
    Given I opened Google cloud page

  Scenario Outline: Get the cost for services
    When I fill the calculator form with parameters:
      | number of instances | operating system | vm class   | instance type                           | gpus | number of gpus | gpu type          | local ssd | datacenter location      | commited usage |
      | 4                   | Free             | regular    | n1-standard-8    (vCPUs: 8, RAM: 30 GB) | true | 1              | NVIDIA Tesla V100 | 2*375 GB  | Frankfurt (europe-west3) | 1 Year         |
      | 3                   | Free             | Preemtible | n1-standard-8    (vCPUs: 8, RAM: 30 GB) | true | 4              | NVIDIA Tesla P100 | 3*375 GB  | Belgium (europe-west1)   | 1 Year         |
      | 3                   | Free             | regular    | n1-standard-8    (vCPUs: 8, RAM: 30 GB) | true | 5              | NVIDIA Tesla P100 | 5*375 GB  | Tokyo (asia-northeast1)  | 3 Years        |


    And I opened email page
    Then Get random email
    When I return to google cloud calculator
    Then enter the email
    And I returned to email page
    Then  Wait for email and check the <cost>

    Examples:
      | cost                               |
      | Estimated Monthly Cost: USD 582.54 |
      | Estimated Monthly Cost: USD 582.54 |
      | Estimated Monthly Cost: USD 582.54 |
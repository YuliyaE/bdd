Feature: Google cloud calculator

  Background:
    Given I opened Google cloud page

  Scenario Outline: Get the cost for services
    When I fill the calculator form with parameters:
      | number of instances | operating system | vm class   | instance type                           | add gpus | number of gpus | gpu type          | local ssd | datacenter location      | commited usage |
      | 4                   | Free             | regular    | n1-standard-8    (vCPUs: 8, RAM: 30 GB) | true     | 1              | NVIDIA Tesla V100 | 2*375 GB  | Frankfurt (europe-west3) | 1 Year         |

    Then  Check the <cost>

    Examples:
      | cost                               |
      | Estimated Monthly Cost: USD 582.54 |


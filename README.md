# EventHubDemo
 Basic read and write event operation on Azure Eventhub. We will create an Eventhub and a Storage account in Azure cloud using terraform and then
 configure our Spring boot app so that it can send Event to Azure Event Hub and receive the same.

### Pre req
- active azure account with billing / subscription enabled
- azure cli installed (to connect and access az services)
- terraform (to create infrastructure in az cloud)
## Running Locally
### Login to Azure cli

- Login to Web azure console
- Serch for micorsoft entra id, then find Tenant id 
- in terminal $ az login --tenant < your tenant id>
- Select your subscription if asked. _**Copy your Subscription ID**_.
- after Sign in and MFA, confirm user by $ az ad signed-in-user show 

### Create Eventhub and checkpoint storage account with terraform
- go to terraform directory $ cd .\terraform\
- initiate terraform $ terraform init 
- Create a terraform.tfvars file inside \terraform
- Provide the following config

`az_region     = "eastus"`

`eventhub_name = "angry-crane-125"`

`namespace_name = "mother-crow-008"`

`az_subs_id = "< Subscription ID>"`
- create a plan to check how many resources will get created. $ terraform plan
- create resources in Azure cloud. $ terraform apply
- Terraform will display newly created resource group

### Add roles to your Azure user
- go to resource groups-> newly created resource group
- click on Resource which is Event Hub Namespace-> Go to access control (IAM)
- Click +Add->Add Role Assignment-> select _Azure Event Hubs Data Owner_ -> in the member tab, select your user -> Review+Assign
- Go Back to Resource Group page-> Click on Resource which is Storage account-> Go to access control (IAM)
- Click +Add->Add Role Assignment-> select _Storage Blob Data Contributor_ -> in the member tab, select your user -> Review+Assign

### Add resource names, connection strings to project config

#### Application.properties
- Go to Azure web console-> Storage Accounts - >Security+Networking->Access Keys then get Storage account name and Connection string
- update spring.cloud.azure.eventhubs.processor.checkpoint-store.account-name= < Storage account name>
- update spring.cloud.azure.eventhubs.processor.checkpoint-store.connection-string= < Connection string>

### Start Application, Send Event, Receive Event

Run the main spring boot application file.
- Check if App has started: hit http://localhost:8082/api/v1/info
- Send an event: hit http://localhost:8082/api/v1/sendEvent?event=your-event-as-string
- Confirm event receipt in the logs
- you can also go to Azure web console->Event Hubs Instance->Data Explorer and send an event from Cloud console and confirm the event receipt in the Spring boot app log.


## Destory all resources in the cloud when you are done and save your money, microsoft is already rich :D
 
- $ terraform destroy
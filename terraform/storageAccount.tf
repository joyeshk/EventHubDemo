

# Random String for unique naming
resource "random_string" "name" {
  length  = 8
  special = false
  upper   = false
  lower   = true
  numeric = false
}

# Create Storage Account
resource "azurerm_storage_account" "sa" {
  name                     = "sa${random_string.name.result}"
  resource_group_name      = azurerm_resource_group.rg.name
  location                 = azurerm_resource_group.rg.location
  account_tier             = "Standard"
  account_replication_type = "RAGRS"
  account_kind             = "StorageV2"
  min_tls_version          = "TLS1_2"
  allow_nested_items_to_be_public = false
}

resource "azurerm_storage_container" "example" {
  name                  = "checkpoint-storage-container"
  storage_account_id    = azurerm_storage_account.sa.id
  container_access_type = "private"
}
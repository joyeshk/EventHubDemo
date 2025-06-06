

resource "azurerm_eventhub_namespace" "eventHub" {
  name                = var.namespace_name
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  sku                 = "Standard"
  capacity            = 1

  tags = {
    environment = "Test"
  }
}

resource "azurerm_eventhub" "eventHub" {
  name              = var.eventhub_name
  namespace_id      = azurerm_eventhub_namespace.eventHub.id
  partition_count   = 2
  message_retention = 1
}
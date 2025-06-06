variable "az_subs_id" {
  type        = string
  description = "Azure Subscription ID"
}
variable "az_region" {
  type        = string
  description = "Azure Region"
}

variable "namespace_name" {
  type        = string
  default     = "default-namespace"
  description = "Name of the Namespace of the eventhub"
}

variable "eventhub_name" {
  type        = string
  default     = "default-eventhub"
  description = "Name of the eventhub"
}

variable "resource_group_location" {
  type        = string
  default     = "eastus"
  description = "Location of the resource group."
}

variable "resource_group_name_prefix" {
  type        = string
  default     = "jk"
  description = "Prefix of the resource group name that's combined with a random ID so name is unique in your Azure subscription."
}
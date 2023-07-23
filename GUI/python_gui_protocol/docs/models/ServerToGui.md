# openapi_client.model.server_to_gui.ServerToGui

Статистика от сервера

## Model Type Info
Input Type | Accessed Type | Description | Notes
------------ | ------------- | ------------- | -------------
dict, frozendict.frozendict,  | frozendict.frozendict,  | Статистика от сервера | 

### Dictionary Keys
Key | Input Type | Accessed Type | Description | Notes
------------ | ------------- | ------------- | ------------- | -------------
**[nearestHotels](#nearestHotels)** | list, tuple,  | tuple,  | Список ближайших КСР | [optional] 
**[nearestCafe](#nearestCafe)** | list, tuple,  | tuple,  | Список ближайших общепитов | [optional] 
**any_string_name** | dict, frozendict.frozendict, str, date, datetime, int, float, bool, decimal.Decimal, None, list, tuple, bytes, io.FileIO, io.BufferedReader | frozendict.frozendict, str, BoolClass, decimal.Decimal, NoneClass, tuple, bytes, FileIO | any string name can be used but the value must be the correct type | [optional]

# nearestHotels

Список ближайших КСР

## Model Type Info
Input Type | Accessed Type | Description | Notes
------------ | ------------- | ------------- | -------------
list, tuple,  | tuple,  | Список ближайших КСР | 

### Tuple Items
Class Name | Input Type | Accessed Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
[**ObjectInfo**](ObjectInfo.md) | [**ObjectInfo**](ObjectInfo.md) | [**ObjectInfo**](ObjectInfo.md) |  | 

# nearestCafe

Список ближайших общепитов

## Model Type Info
Input Type | Accessed Type | Description | Notes
------------ | ------------- | ------------- | -------------
list, tuple,  | tuple,  | Список ближайших общепитов | 

### Tuple Items
Class Name | Input Type | Accessed Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
[**ObjectInfo**](ObjectInfo.md) | [**ObjectInfo**](ObjectInfo.md) | [**ObjectInfo**](ObjectInfo.md) |  | 

[[Back to Model list]](../../README.md#documentation-for-models) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to README]](../../README.md)


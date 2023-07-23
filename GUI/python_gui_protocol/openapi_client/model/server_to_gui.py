# coding: utf-8

"""
    Базовые модели для запросов

    No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""

from datetime import date, datetime  # noqa: F401
import decimal  # noqa: F401
import functools  # noqa: F401
import io  # noqa: F401
import re  # noqa: F401
import typing  # noqa: F401
import typing_extensions  # noqa: F401
import uuid  # noqa: F401

import frozendict  # noqa: F401

from openapi_client import schemas  # noqa: F401


class ServerToGui(
    schemas.DictSchema
):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.

    Статистика от сервера
    """


    class MetaOapg:
        
        class properties:
            
            
            class nearestHotels(
                schemas.ListSchema
            ):
            
            
                class MetaOapg:
                    
                    @staticmethod
                    def items() -> typing.Type['ObjectInfo']:
                        return ObjectInfo
            
                def __new__(
                    cls,
                    _arg: typing.Union[typing.Tuple['ObjectInfo'], typing.List['ObjectInfo']],
                    _configuration: typing.Optional[schemas.Configuration] = None,
                ) -> 'nearestHotels':
                    return super().__new__(
                        cls,
                        _arg,
                        _configuration=_configuration,
                    )
            
                def __getitem__(self, i: int) -> 'ObjectInfo':
                    return super().__getitem__(i)
            
            
            class nearestCafe(
                schemas.ListSchema
            ):
            
            
                class MetaOapg:
                    
                    @staticmethod
                    def items() -> typing.Type['ObjectInfo']:
                        return ObjectInfo
            
                def __new__(
                    cls,
                    _arg: typing.Union[typing.Tuple['ObjectInfo'], typing.List['ObjectInfo']],
                    _configuration: typing.Optional[schemas.Configuration] = None,
                ) -> 'nearestCafe':
                    return super().__new__(
                        cls,
                        _arg,
                        _configuration=_configuration,
                    )
            
                def __getitem__(self, i: int) -> 'ObjectInfo':
                    return super().__getitem__(i)
            __annotations__ = {
                "nearestHotels": nearestHotels,
                "nearestCafe": nearestCafe,
            }
    
    @typing.overload
    def __getitem__(self, name: typing_extensions.Literal["nearestHotels"]) -> MetaOapg.properties.nearestHotels: ...
    
    @typing.overload
    def __getitem__(self, name: typing_extensions.Literal["nearestCafe"]) -> MetaOapg.properties.nearestCafe: ...
    
    @typing.overload
    def __getitem__(self, name: str) -> schemas.UnsetAnyTypeSchema: ...
    
    def __getitem__(self, name: typing.Union[typing_extensions.Literal["nearestHotels", "nearestCafe", ], str]):
        # dict_instance[name] accessor
        return super().__getitem__(name)
    
    
    @typing.overload
    def get_item_oapg(self, name: typing_extensions.Literal["nearestHotels"]) -> typing.Union[MetaOapg.properties.nearestHotels, schemas.Unset]: ...
    
    @typing.overload
    def get_item_oapg(self, name: typing_extensions.Literal["nearestCafe"]) -> typing.Union[MetaOapg.properties.nearestCafe, schemas.Unset]: ...
    
    @typing.overload
    def get_item_oapg(self, name: str) -> typing.Union[schemas.UnsetAnyTypeSchema, schemas.Unset]: ...
    
    def get_item_oapg(self, name: typing.Union[typing_extensions.Literal["nearestHotels", "nearestCafe", ], str]):
        return super().get_item_oapg(name)
    

    def __new__(
        cls,
        *_args: typing.Union[dict, frozendict.frozendict, ],
        nearestHotels: typing.Union[MetaOapg.properties.nearestHotels, list, tuple, schemas.Unset] = schemas.unset,
        nearestCafe: typing.Union[MetaOapg.properties.nearestCafe, list, tuple, schemas.Unset] = schemas.unset,
        _configuration: typing.Optional[schemas.Configuration] = None,
        **kwargs: typing.Union[schemas.AnyTypeSchema, dict, frozendict.frozendict, str, date, datetime, uuid.UUID, int, float, decimal.Decimal, None, list, tuple, bytes],
    ) -> 'ServerToGui':
        return super().__new__(
            cls,
            *_args,
            nearestHotels=nearestHotels,
            nearestCafe=nearestCafe,
            _configuration=_configuration,
            **kwargs,
        )

from openapi_client.model.object_info import ObjectInfo
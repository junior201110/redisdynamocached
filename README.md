# Exemplo de cacheamento com Redis em Java

Foi usado o Spring Framework e o DynamoDB


O programa insere um usuário e lista todos os usuário, no Dynamo.

Quando consultado um usuário unitariamente, o programa verifica se o mesmo está no cache.
Caso não esteja, ele busca o usuário no DynamoDB, manda o usuário para o cache e retorna os dados do usuário;



# Documentos consultados

- [Crud do Item](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/JavaDocumentAPIItemCRUD.html)
- [Mapper de Java Objects](https://aws.amazon.com/pt/blogs/developer/storing-java-objects-in-amazon-dynamodb-tables/)
- [Armazenar Objetos Java No DynamoDB](https://aws.amazon.com/pt/blogs/developer/storing-java-objects-in-amazon-dynamodb-tables/)
- [Serialização de Items](https://stackoverflow.com/questions/30793481/dynamodb-jsonmarshaller-cannot-deserialize-list-of-object)
- [Mapper Annotations](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBMapper.Annotations.html)

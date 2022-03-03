## Table

| Tables   |      Are      |  Cool |
|----------|:-------------:|------:|
| col 1 is |  left-aligned | $1600 |
| col 2 is |    centered   |   $12 |
| col 3 is | right-aligned |    $1 |

| category  | -  | -  |
|---|---|---|
| **parent_id**  | UUID  | K  |
| **category_id**  |  UUID | K |
| name  |  text |   |



## Flow

```mermaid
graph TD;
    A-->B;
    A-->C;
    B-->D;
    C-->D;
```

## Er

```mermaid
erDiagram

category {
    UUID parent_id 
    UUID category_id
    TEXT name
    TEXT image
    LIST_OF_TEXT products
}

product {
    TEXT product_id
    TEXT product_group
    TEXT name
 TEXT brand
 TEXT model_number
 TEXT short_desc
 TEXT long_desc
 MAP_OF_TEXT_TEXT specifications
 MAP_OF_TEXT_TEXT linked_documents
 SET_OF_TEXT images
}

price {
    TEXT product_id
    TEXT store_id
    DECIMAL value
}


 category ||--o{ product : use

  price||--o{ product : use
```

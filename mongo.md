### Queries For MongoDB

### Fonctions
```python
# Lister les bases
show databases;

# Utiliser une base
use X

# Afficher les collections
show collections;

# Start/Stop engine
sudo mongod --shutdown --config /etc/mongodb.conf
sudo mongod --fork --config /etc/mongodb.conf
```

### Recherches

```python
# findOne
db.col.findOne({"fieldname":"value", "fieldname2" : value2}, {"_id":false});
db.col.find({"field":"value", "field2" : "value2"},{"_id":false})
db.col.find({"field":{$gt : 50, $lte : 60}, "fieldname2" : "value2"},{"_id":false})

# exist
db.col.find({ attribute : { $exists : true }});

# type (2=String)
db.col.find({ attribute : { $type : 2 }});

# regex
db.col.find({ attribute : { $regex : "blabla" }});
db.col.find({ name : { $regex : "q" }, email : { $exists: true } } );

# OR
db.col.find( { $or : [ { field : {$lt : 50} }, {field : {$gt : 90}} ] })

# AND (inutile)
db.col.find( { $and : [ { field : {$lt : 50} }, {field : {$gt : 90}} ] })

# $all 
db.col.find( { attribute : { $all : [ "val1", "val2" ] } });

# $in
db.col.find( { attribute : { $in : [ "val1", "val2" ] } });

# dot.notation (regarde uniquement le champ recherché)
db.col.find({ "attribute.sub" : "value"})

# Skip, limit
db.col.find({type : "exam"}).sort({ score : -1 }).skip(50).limit(20)

# Sort
bb.col.find({type: "exam", score : { $gte : 65} }).sort({ score : 1 });

# Cursor
cur = db.col.find();null;
while(cur.hasNext()) printjson(cur.next());

# Count
db.col.count({ query : "value"});
``` 
### Mises a jour
```python
# Update tout le document
db.mycol.update( { query }, { newdocument})
db.people.update( {name : "Alice"}, { name:"Toto", salary:10000 })

# set (ajoute ou update un champ)
db.people.update( {name : "Alice"}, { $set : { age : 30} )

# inc ajoute (si non existe cree avec le inc)
db.people.update( {name : "Alice"}, { $inc : { age : 1} )

# unset (enlève un champ du document)
db.people.update( {name : "Alice"}, { $unset : "age" )
db.users.update( { "_id" : "jimmy" }, {$unset : {"interests" : [ "debating" , "politics" ] }} );

# push, pop, pull, pushall
db.mycoll.update( { query}, { $set : { "tab.index" : "value" }});

# ajouter à la fin
db.mycoll.update( { query}, { $push : { "tab" : value}});
db.mycoll.update( { query}, { $pushALL : { "tab" : [val1, val2, val3] }});

# enlever le dernier
db.mycoll.update( { query}, { $pop : { "tab" : 1 }});

# enlever le premier
db.mycoll.update( { query}, { $pop : { "tab" : -1 }});

# enlever n'importe ou
db.mycoll.update( { query}, { $pull : { "tab" : "value" }});
db.mycoll.update( { query}, { $pullALL : { "tab" : [val1, val2, val3] }});

# Ajouter element si non existant
db.mycoll.update( { query}, { $addToSet : { "tab" : "value" }});

# Upserts
db.mycoll.update( { query }, { $set : { "field" : "value" }, { upsert : true}});

# Multi-update (Le coté transactionnel n'est pas garanti)
db.mycoll.update( {}, { $set : { "field" : "value" },  { multi : true}});
db.scores.update({ score : { $lt : 70 }}, { $inc : { score : 20 }}, {multi : true} );
``` 

### Suppressions
```python
# Remove
db.mycol.remove( {query});

# Supprimer tous les documents 1 par 1
db.mycol.remove({});

# Supprimer tous les documents d'un coup
db.mycol.drop();
```

### CONNEXION
```python
mongo --port 27017 -u user -p password --authenticationDatabase admin
mongo --port 22012 -u user -p password -db dico
mongo localhost:22012/USERS -u jmoisson -p xxxx
mongo --port 22012 -u user -p xxxx --authenticationDatabase admin
db.auth("user","xxx");
```

### USERS
```python
db.createUser( { user: "utilisateur", pwd: "cccc", roles:[ {role: "userAdminAnyDatabase", db: "admin"}] })
db.createUser({ "user": "user", "pwd": "password",    "roles":[  {  "role": "userAdmin",  "db": "USERS" },  {  "role": "dbOwner",  db: "USERS" }] });

db.grantRolesToUser("loulou", [ {  "role": "readWriteAnyDatabase",  "db": "admin" } ] )
db.grantRolesToUser("loulou", [ { "role" : "readWrite","db" : "dico"}, {"role" : "read", "db" : "dico"}, {"role" : "dbOwner","db" : "dico"},{"role" : "userAdmin","db" : "dico"}] )
db.grantRolesToUser("jmoisson", [ {  "role": "userAdmin",  "db": "theta" }, {role: "dbOwner", db: "theta"} ] )
db.grantRolesToUser("clunven", [ {role: "dbOwner", db: "USER_TAGS"}, { "role": "userAdmin",  "db": "USER_TAGS" } ] )

db.updateUser("jmoisson", { roles: [ { "role":"read", "db": "USER_TAGS" }, { "role":"dbAdmin", "db": "USER_TAGS" }, { "role":"readWrite", "db": "USER_TAGS" }, { "role":"userAdmin", "db": "USER_TAGS" },  { "role": "dbOwner", db: "USER_TAGS" } ]  } );
db.updateUser("jmoisson", { roles: [ { "role":"read", "db": "theta" }, { "role":"dbAdmin", "db": "theta" }, { "role":"readWrite", "db": "theta" }, { "role":"userAdmin", "db": "theta" },  { "role": "dbOwner", db: "theta" } ]  } );

db.addUser('jmoisson', 'moisson2014')
db.getUser("jmoisson");
db.getRole("jmoisson");
db.removeUser('jmoisson')
```

### ARTICLES
```python
db.createCollection("article",{_id:'url'});
db.article.distinct({"sourceFeed.title"});
db.article.count({"publishedDate": { $gt:ISODate("2014-09-22T20:25:00Z") }});
db.article.find( { "_id" : "http://www.cnbc.com/id/102087227" }, {"title":1});
db.article.find( { }, {"title":1}).sort({"publishedDate",-1}).limit(5);
db.article.find( { "_id" : "http://www.cnbc.com/id/102185707" }, {"neightbours":1});
db.article.find( { "sourceFeed.source" : cnbc" }, {"_id":0, "url":1});
db.article.update( { "_id" : "http://www.cnbc.com/id/102185707" }, { $addToSet : { "neightbours" : "val1" }});
```

### DISTANCE
```python
db.distances.find({"distance": {$lt:1 }})
db.distances.ensureIndex({ "p1":1, "distance":-1});
```

### ACCOUNT
```python
db.createCollection("account", {_id:'username'});
db.account.find({"username":"cedrick"})
db.account.insert( {"username":"clu","password":"xxxx","mail":"a.a@a.com","categories": [ "Politic", "Economy", "Science"],"roles": [ "USER", "ADMIN"] });
db.account.insert( {"username":"clun","password":"clun","mail":"a.a@a.com","setOfCategory": [ "Politic", "Economy", "Science"],"setOfRoles": [ "ROLE_USER", "ROLE_ADMIN"], "firstName":"c", "lastName":"e", "website":"http://ff4j.org" });
db.account.update({ "username":"cedrick" }, { $unset: { "tagSet": ""} })
db.account.update({ "username":"user" }, { $set: { "setOfRoles": [ "ROLE_USER", "ROLE-ADMIN"]} })
db.account.update({ "username":"cedrick" },  { $set : { "tagSet" : [ { "idTag" : 1, "label" : "Thema", "seqId" : 1, "values" : [ { "name" : "Politic", 	"id" : 1 }, { "name" : "Corporate", "id" : 2 }, { "name" : "Economy", 	"id" : 3 }, { "name" : "Bourse", 	"id" : 4 }, { "name" : "Banque", 	"id" : 5 }, { "name" : "Other", "id" : 6 } ] }, { "label" : "Samples", "seqId":2,"values" : [ { "name" : "Peu", "id" : 1 }, { "name" : "Beaucoup", "id" : 2 } ] } ] } });
db.account.update({ "username":"phour" },  { $set:   { "idTag": 2} })
db.account.update({ "username":"phour" },  { $unset: { "seqid": ""} })
```

### BACKUP et ADMINS
```python
# Backup
mongodump --port 22012 --db NEWS --collection word --username jmoisson --password moisson2014
mongodump --port 22012 --db dico --collection word --username user --password user2014

# Restore
mongorestore --port 22012 --db dico --username jmoisson --password moisson2014 dump

# Rename
db.runCommand({renameCollection:"NEWS.word",to:"dico.word"})
db.runCommand({renameCollection:"NEWS.ignoredWord",to:"dico.ignoredWord"})

# Get last news
db.article.find({},{"publishedDate":1, "status":1}).sort({publishedDate:-1}).limit(5);
db.article.remove({"url":"http://www.cnbc.com/id/102387079"});
```

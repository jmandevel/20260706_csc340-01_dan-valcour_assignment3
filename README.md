# 20260706_CSC340-01_dan-valcour_assignment3

## Get list of all characters 
* GET https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters
### Response
```json
[
  {
    "aggressive": true,
    "avatar": false,
    "characterId": 1,
    "createdAt": "2026-07-06 02:38",
    "description": "Brown bears are dangerous wild animals that can be found roaming the lands of Wurm. They are carnivorous,\n        meaning they will eat other creatures and players if they have the chance. They are capable of swimming, so\n        players cannot excape an aggressive brown bear by jumping into a water. Butchering a slain brown bear\n        produces meat, fur, and bear teeth, which can be used in crafting. With level 60 animal taming level, players\n        can tame brown bears and keep them as pets. They can be a useful companion when facing off against hostile\n        wildlife. Players with level 23 body control can ride tamed brown bears as a mount.\n",
    "ingameDescription": "The brown bear has a distinctive hump on the shoulders, and long deadly claws\n          on the front paws.",
    "name": "Brown Bear\t",
    "origin": "Wurm",
    "passive": false,
    "spider": false
  },
  {
    "aggressive": true,
    "avatar": false,
    "characterId": 2,
    "createdAt": "2026-07-06 03:14",
    "description": "A feral cat found in the wilderness.",
    "ingameDescription": "A small wild cat, fierce and aggressive.",
    "name": "Wild Cat",
    "origin": "Wurm",
    "passive": false,
    "spider": false
  }
]
```
## Get character of a specific id
* GET https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters/{id}
### Response
```json
{
    "aggressive": true,
    "avatar": false,
    "characterId": 1,
    "createdAt": "2026-07-06 02:38",
    "description": "Brown bears are dangerous wild animals that can be found roaming the lands of Wurm. They are carnivorous,\n        meaning they will eat other creatures and players if they have the chance. They are capable of swimming, so\n        players cannot excape an aggressive brown bear by jumping into a water. Butchering a slain brown bear\n        produces meat, fur, and bear teeth, which can be used in crafting. With level 60 animal taming level, players\n        can tame brown bears and keep them as pets. They can be a useful companion when facing off against hostile\n        wildlife. Players with level 23 body control can ride tamed brown bears as a mount.\n",
    "ingameDescription": "The brown bear has a distinctive hump on the shoulders, and long deadly claws\n          on the front paws.",
    "name": "Brown Bear\t",
    "origin": "Wurm",
    "passive": false,
    "spider": false
}
```
## add a new character
* POST https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters
### Body
```json
{
  "name":"Wild Cat",
  "description":"A feral cat found in the wilderness.",
  "ingameDescription":"A small wild cat, fierce and aggressive.",
  "origin":"Wurm",
  "avatar":"false",
  "spider":"false",
  "passive":"false",
  "aggressive":"true"
}
```
### Response
```json
{
  "aggressive": true,
  "avatar": false,
  "characterId": 2,
  "createdAt": "2026-07-06 03:14",
  "description": "A feral cat found in the wilderness.",
  "ingameDescription": "A small wild cat, fierce and aggressive.",
  "name": "Wild Cat",
  "origin": "Wurm",
  "passive": false,
  "spider": false
}
```
## modify a character 
* https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters/{id} 
### Body
```json
{
  "name":"Wild Cat",
  "description":"A feral cat found in wild places.",
  "ingameDescription":"A small wild cat, fierce and aggressive.",
  "origin":"Wurm",
  "avatar":"false",
  "spider":"false",
  "passive":"false",
  "aggressive":"true"
}
```
### Response
```json
{
  "aggressive": true,
  "avatar": false,
  "characterId": 2,
  "createdAt": "2026-07-06 03:22",
  "description": "A feral cat found in wild places.",
  "ingameDescription": "A small wild cat, fierce and aggressive.",
  "name": "Wild Cat",
  "origin": "Wurm",
  "passive": false,
  "spider": false
}
```
## delete a character
* DELETE https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters/{id}
##  get all characters from a specific origin world
* GET https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters/origin?query={name}
### Response
```json
[
  {
    "aggressive": true,
    "avatar": false,
    "characterId": 1,
    "createdAt": "2026-07-06 02:38",
    "description": "Brown bears are dangerous wild animals that can be found roaming the lands of Wurm. They are carnivorous,\n        meaning they will eat other creatures and players if they have the chance. They are capable of swimming, so\n        players cannot excape an aggressive brown bear by jumping into a water. Butchering a slain brown bear\n        produces meat, fur, and bear teeth, which can be used in crafting. With level 60 animal taming level, players\n        can tame brown bears and keep them as pets. They can be a useful companion when facing off against hostile\n        wildlife. Players with level 23 body control can ride tamed brown bears as a mount.\n",
    "ingameDescription": "The brown bear has a distinctive hump on the shoulders, and long deadly claws\n          on the front paws.",
    "name": "Brown Bear\t",
    "origin": "Wurm",
    "passive": false,
    "spider": false
  },
  {
    "aggressive": true,
    "avatar": false,
    "characterId": 2,
    "createdAt": "2026-07-06 03:22",
    "description": "A feral cat found in wild places.",
    "ingameDescription": "A small wild cat, fierce and aggressive.",
    "name": "Wild Cat",
    "origin": "Wurm",
    "passive": false,
    "spider": false
  }
]
```
## get all characters with names that contain the given text
* GET https://two0260706-csc340-01-dan-valcour.onrender.com/api/characters/search?query={name}
### Response
```json
[
  {
    "aggressive": true,
    "avatar": false,
    "characterId": 1,
    "createdAt": "2026-07-06 02:38",
    "description": "Brown bears are dangerous wild animals that can be found roaming the lands of Wurm. They are carnivorous,\n        meaning they will eat other creatures and players if they have the chance. They are capable of swimming, so\n        players cannot excape an aggressive brown bear by jumping into a water. Butchering a slain brown bear\n        produces meat, fur, and bear teeth, which can be used in crafting. With level 60 animal taming level, players\n        can tame brown bears and keep them as pets. They can be a useful companion when facing off against hostile\n        wildlife. Players with level 23 body control can ride tamed brown bears as a mount.\n",
    "ingameDescription": "The brown bear has a distinctive hump on the shoulders, and long deadly claws\n          on the front paws.",
    "name": "Brown Bear\t",
    "origin": "Wurm",
    "passive": false,
    "spider": false
  }
]
```
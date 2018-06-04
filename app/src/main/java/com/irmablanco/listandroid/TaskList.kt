package com.irmablanco.listandroid

class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList<String>()) {
}

/*
* At this point we need an object to read our tasklist
* and to do this we use sharedPreferences, we will keep
* this centralized in one object in a new class called
* ListDataManager
* **/
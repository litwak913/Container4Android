package io.github.litwak913.linuxstarter

class Container(name:String,status:Int){
    lateinit var name:String
    var status:Int = 0
    init {
        this.name=name
        this.status=status
    }
}
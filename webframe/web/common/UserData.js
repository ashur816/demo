function UserData(aJsonNode) {
    this.List = null;
    this.initial(aJsonNode);
}

function createUserData(aJsonNode, isCreate) {
    if (!aJsonNode && !isCreate) return null;
    return new UserData(aJsonNode);
}

UserData.prototype.initial = UserData_initial;
UserData.prototype.getValueByName = UserData_getValueByName;

function UserData_initial(aJsonNode) {
    if (aJsonNode == null) return;
    if (aJsonNode.length == 0) return;
    var tmpObj = null;
    for (var i = 0; i < aJsonNode.length; i++) {
        tmpObj.NAME = aJsonNode.childNodes(i).attributes.getNamedItem("n").nodeValue;
        tmpObj.VALUE = aJsonNode.childNodes(i).text;
    }
}

function UserDataClass_hasPara(aParaName) {
    var ri = -1;
    if (this.List == null) return -1;
    if (aParaName == null) return -1;
    for (var i = 0; i < this.count(); i++) {
        if (this.getName(i) != null && aParaName != null &&
            this.getName(i).toUpperCase() == aParaName.toUpperCase()) {
            ri = i;
            break;
        }
    }
    return ri;
}

function UserData_getValueByName(aParaName) {
    var tmpObj = this.getObject(i);
}



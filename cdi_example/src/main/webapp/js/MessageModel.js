function Message(id, message) {
    var self = this;
    self.id = id;
    self.message = message;
}

function MessageModel() {


}

ko.applyBindings(new MessageModel());
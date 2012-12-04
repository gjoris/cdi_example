function Message(id, message) {
    var self = this;
    self.id = id;
    self.message = message;
}

function MessageModel() {

    var self = this;
    self.messageArray = ko.observableArray();

//    self.refresh = function() {
//        $.ajax()
//    }

}

ko.applyBindings(new MessageModel());
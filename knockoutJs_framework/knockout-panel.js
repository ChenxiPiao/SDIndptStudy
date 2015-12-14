define(['jquery', '/js/aspn/widgets/docs/documentUtils.js', 'ko'], function ($, documentUtils, ko) {

    /**
    * Initializes the Email panel
    */
    function initEmailPanel(container, widget) {
            var html = [
                '<div class="documents-widget-panel documents-widget-email-panel">',
                    '<div class="email-header">',
                        '<span class=email-title>Knockout Demo</span>',
                        '<button type="button" class="dbutton done-button">Done</button>',
                    '</div>',
                    '<div class="email-content">',
                    '</div>',
                '</div>'
            ].join('');

            var $emailPanel = $(html).appendTo(container);

            $emailPanel.find('.done-button').on('click', function () {
                documentUtils.docEvent(widget, 'modeChange', { mode: 'search' });
                return false;
            });
            
            var EmailViewModel = function () {                
            };
            var emailViewModel = new EmailViewModel();

            // bind the view model to the file uploads table
            ko.applyBindings(emailViewModel, $emailPanel.get(0));

            //documentUtils.docEvent.subscribe(widget, function (event) {
            //    if (event.type == 'modeChange' && event.source == widget) {                    
            //    }
            //});

            return $emailPanel;
    };

    return initEmailPanel;
});
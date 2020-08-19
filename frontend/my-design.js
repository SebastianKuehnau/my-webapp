import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class MyDesign extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; margin: var(--lumo-space-l); padding: var(--lumo-space-m); align-items: flex-start; justify-content: flex-start;" theme="spacing-l">
 <vaadin-text-field id="vaadinTextField" style="width: 300px;" placeholder="Please enter your name!"></vaadin-text-field>
 <vaadin-button id="vaadinButton" theme="design-blue">
  submit
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'my-design';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MyDesign.is, MyDesign);

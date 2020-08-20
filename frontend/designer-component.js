import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class DesignerComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                    width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m); align-items: center; justify-content: center;" theme="spacing">
 <span>Bitte geben Sie Ihren Namen ein:</span>
 <vaadin-text-field id="vaadinTextField" placeholder="ihr Name"></vaadin-text-field>
 <vaadin-button theme="primary" id="vaadinButton">
  Absenden
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'designer-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DesignerComponent.is, DesignerComponent);

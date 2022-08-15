import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AppComponent } from './app.component';

const contextPath = 'http:://localhost:8189/';

@NgModule({
    imports:      [ BrowserModule, ReactiveFormsModule ],
    declarations: [ AppComponent ],
    bootstrap:    [ AppComponent ]
})
@Component({
    selector : 'addform ',
    templateUrl: contextPath + '/addform.html',
    styleUrls: ['style/addform.css']
})
export class AppModule { }

export class AppComponent {
    form: FormGroup;
    constructor(fb: FormBuilder) {}

    ngOnInit(){
        this.initForm();
    }

    initForm() {
        this.form = this.fb.group({
            title : [null],
            price : [null],
            category: [null]
            });
    }
}
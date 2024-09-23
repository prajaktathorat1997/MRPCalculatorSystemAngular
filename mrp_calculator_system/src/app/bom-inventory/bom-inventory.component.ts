import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bom-inventory',
  templateUrl: './bom-inventory.component.html',
  styleUrls: ['./bom-inventory.component.css'],
})
export class BomInventoryComponent implements OnInit {
  bomItems: { name: string; quantity: number }[] = [{ name: '', quantity: 0 }];
  inventoryItems: { name: string; stock: number }[] = [{ name: '', stock: 0 }];
  output: any;
  showOutput: boolean = false;

  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    document.body.className = 'bg_image';
  }

  addBOMItem() {
    this.bomItems.push({ name: '', quantity: 0 });
  }

  removeBOMItem(index: number) {
    this.bomItems.splice(index, 1);
  }

  addInventoryItem() {
    this.inventoryItems.push({ name: '', stock: 0 });
  }

  removeInventoryItem(index: number) {
    this.inventoryItems.splice(index, 1);
  }

  onSubmit() {
    const validBOMItems = this.bomItems.filter(
      (item) => item.name.trim() !== ''
    );

    const duplicateBOMNames = this.findDuplicates(
      validBOMItems.map((item) => item.name)
    );

    if (duplicateBOMNames.length > 0) {
      console.error('Duplicate BOM names:', duplicateBOMNames);
      alert('Duplicate BOM names found: ' + duplicateBOMNames.join(', '));
      return;
    }

    const validInventoryItems = this.inventoryItems.filter(
      (item) => item.name.trim() !== ''
    );

    const duplicateInventoryNames = this.findDuplicates(
      validInventoryItems.map((item) => item.name)
    );

    if (duplicateInventoryNames.length > 0) {
      console.error('Duplicate Inventory names:', duplicateInventoryNames);
      alert(
        'Duplicate Inventory names found: ' + duplicateInventoryNames.join(', ')
      );
      return;
    }

    if (validBOMItems.length > 0 || validInventoryItems.length > 0) {
      const data = {
        bom: validBOMItems,
        inventory: validInventoryItems,
      };

      this.http
        .post('http://localhost:8666/myapp/mrp/calculate', data)
        .subscribe(
          (response) => {
            this.output = response;
            this.showOutput = true;
            setTimeout(() => {
              this.scrollToOutput();
            }, 80);
          },
          (error) => {
            alert(
              'There was an error processing your request. Please try again.'
            );
            console.error('Error:', error);
          }
        );
    } else {
      alert('Please enter valid BOM and inventory items.');
    }
    
  }

  findDuplicates(array: string[]): string[] {
    const uniqueItems = new Set();
    const duplicates = new Set();

    array.forEach((item) => {
      if (uniqueItems.has(item)) {
        duplicates.add(item);
      } else {
        uniqueItems.add(item);
      }
    });
    return Array.from(duplicates) as string[];
  }

  scrollToOutput() {
    const outputElement = document.getElementById('outputSection');
    if (outputElement) {
      outputElement.scrollIntoView({ behavior: 'smooth' });
    }
  }
}

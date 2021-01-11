import { Product } from './types';

export function checkIsSelected(selectedProducts: Product[], product: Product) {
    return selectedProducts.some(item => item.id === product.id);
}


//Number Format
export function formatPrice(price: number) {
    const formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
        //minimumFractionDigits: 3
    });

    return formatter.format(price)
}
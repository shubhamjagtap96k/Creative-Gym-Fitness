import Link from "next/link";
import { Dumbbell, Instagram, Facebook, Twitter, MapPin, Mail, Phone } from "lucide-react";

export function Footer() {
    return (
        <footer className="bg-card border-t py-12 md:py-16">
            <div className="container mx-auto px-4 grid grid-cols-1 md:grid-cols-4 gap-8">
                <div className="space-y-4">
                    <div className="flex items-center gap-2">
                        <Dumbbell className="w-6 h-6 text-primary" />
                        <span className="text-xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-primary to-secondary">
                            Creative Gym
                        </span>
                    </div>
                    <p className="text-muted-foreground text-sm">
                        Unlock your potential with premium equipment, expert trainers, and a supportive community.
                    </p>
                    <div className="flex gap-4">
                        <Link href="#" className="p-2 bg-secondary/10 rounded-full hover:bg-secondary/20 transition-colors">
                            <Instagram className="w-4 h-4 text-secondary" />
                        </Link>
                        <Link href="#" className="p-2 bg-primary/10 rounded-full hover:bg-primary/20 transition-colors">
                            <Facebook className="w-4 h-4 text-primary" />
                        </Link>
                        <Link href="#" className="p-2 bg-sky-500/10 rounded-full hover:bg-sky-500/20 transition-colors">
                            <Twitter className="w-4 h-4 text-sky-500" />
                        </Link>
                    </div>
                </div>

                <div>
                    <h3 className="font-semibold mb-4 text-lg">Quick Links</h3>
                    <ul className="space-y-2 text-muted-foreground">
                        <li><Link href="/plans" className="hover:text-primary transition-colors">Plans</Link></li>
                        <li><Link href="/classes" className="hover:text-primary transition-colors">Classes</Link></li>
                        <li><Link href="/trainers" className="hover:text-primary transition-colors">Trainers</Link></li>
                        <li><Link href="/blog" className="hover:text-primary transition-colors">Blog</Link></li>
                    </ul>
                </div>

                <div>
                    <h3 className="font-semibold mb-4 text-lg">Support</h3>
                    <ul className="space-y-2 text-muted-foreground">
                        <li><Link href="/contact" className="hover:text-primary transition-colors">Contact Us</Link></li>
                        <li><Link href="/faq" className="hover:text-primary transition-colors">FAQs</Link></li>
                        <li><Link href="/privacy" className="hover:text-primary transition-colors">Privacy Policy</Link></li>
                        <li><Link href="/terms" className="hover:text-primary transition-colors">Terms of Service</Link></li>
                    </ul>
                </div>

                <div className="space-y-4">
                    <h3 className="font-semibold mb-4 text-lg">Contact</h3>
                    <div className="flex items-start gap-3 text-muted-foreground">
                        <MapPin className="w-5 h-5 text-primary shrink-0" />
                        <span>123 Fitness Blvd, Gym City, GC 45678</span>
                    </div>
                    <div className="flex items-center gap-3 text-muted-foreground">
                        <Phone className="w-5 h-5 text-primary shrink-0" />
                        <span>+1 (555) 123-4567</span>
                    </div>
                    <div className="flex items-center gap-3 text-muted-foreground">
                        <Mail className="w-5 h-5 text-primary shrink-0" />
                        <span>hello@creativegym.com</span>
                    </div>
                </div>
            </div>
            <div className="container mx-auto px-4 mt-12 pt-8 border-t text-center text-muted-foreground text-sm">
                © {new Date().getFullYear()} Creative Gym & Fitness. All rights reserved.
            </div>
        </footer>
    );
}
